package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Person
import com.example.findmovienew.util.Resource

interface NamesRepository {
    fun searhNames(expression: String): Resource<List<Person>>
}