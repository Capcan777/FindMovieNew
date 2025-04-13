package com.example.findmovienew.data

import com.example.findmovienew.data.dto.NamesSearchRequest
import com.example.findmovienew.data.dto.NamesSearchResponse
import com.example.findmovienew.domain.api.NamesRepository
import com.example.findmovienew.domain.models.Person
import com.example.findmovienew.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NamesRepositoryImpl(private val networkClient: NetworkClient, ) : NamesRepository {

    override fun searchNames(expression: String): Flow<Resource<List<Person>>> = flow {
        val response = networkClient.doRequestSuspend(NamesSearchRequest(expression))
         when(response.resultCode) {
            - 1 -> {
                emit(Resource.Error("Проверьте подключение к интернету"))
            }
            200 -> {
                with(response as NamesSearchResponse) {
                    val data = results.map {
                        Person(id = it.id, name = it.title, description = it.description, image = it.image)
                    }
                    emit(Resource.Success(data))
                }
            }
            else -> {
                emit(Resource.Error("Ошибка сервера"))
            }
        }
    }
}