package com.example.findmovienew.data

import com.example.findmovienew.data.dto.NamesSearchRequest
import com.example.findmovienew.data.dto.NamesSearchResponse
import com.example.findmovienew.domain.api.NamesRepository
import com.example.findmovienew.domain.models.Person
import com.example.findmovienew.util.Resource

class NamesRepositoryImpl(private val networkClient: NetworkClient, ) : NamesRepository {

    override fun searhNames(expression: String): Resource<List<Person>> {
        val response = networkClient.doRequest(NamesSearchRequest(expression))
        return when(response.resultCode) {
            - 1 -> {
                Resource.Error("Проверьте подключение к интернету")
            }
            200 -> {
                with(response as NamesSearchResponse) {
                    Resource.Success(results.map {
                        Person(id = it.id, name = it.title, description = it.description, image = it.image)
                    })
                }
            }
            else -> {
                Resource.Error("Ошибка сервера")
            }
        }
    }
}