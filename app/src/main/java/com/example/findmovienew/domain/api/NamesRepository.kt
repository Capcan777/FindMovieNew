package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Person
import com.example.findmovienew.util.Resource
import kotlinx.coroutines.flow.Flow

interface NamesRepository {
    fun searchNames(expression: String): Flow<Resource<List<Person>>>
}