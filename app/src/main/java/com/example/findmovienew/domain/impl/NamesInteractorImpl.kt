package com.example.findmovienew.domain.impl

import com.example.findmovienew.domain.api.NamesInteractor
import com.example.findmovienew.domain.api.NamesRepository
import com.example.findmovienew.domain.models.Person
import com.example.findmovienew.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.Executors

class NamesInteractorImpl(private val repository: NamesRepository) : NamesInteractor{


    override fun searchNames(expression: String): Flow<Pair<List<Person>?, String?>> {
        return repository.searchNames(expression).map { result ->
            when(result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }
                is Resource.Error -> {
                    Pair(null, result.message)
                }
            }
        }
    }
}