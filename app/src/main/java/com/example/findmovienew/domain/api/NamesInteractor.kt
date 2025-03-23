package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Person

interface NamesInteractor {
    fun searchNames(expression: String, consumer: NamesConsumer)

    interface NamesConsumer {
        fun consume(foundNames: List<Person>?, errorMessage: String?)

    }
}