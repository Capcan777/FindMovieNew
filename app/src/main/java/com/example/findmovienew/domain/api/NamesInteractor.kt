package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Person
import kotlinx.coroutines.flow.Flow

interface NamesInteractor {
    fun searchNames(expression: String): Flow<Pair<List<Person>?, String?>>

}