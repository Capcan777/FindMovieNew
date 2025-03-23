package com.example.findmovienew.domain.impl

import com.example.findmovienew.domain.api.NamesInteractor
import com.example.findmovienew.domain.api.NamesRepository
import com.example.findmovienew.util.Resource
import java.util.concurrent.Executors

class NamesInteractorImpl(private val repository: NamesRepository) : NamesInteractor{

    private val executor = Executors.newCachedThreadPool()

    override fun searchNames(expression: String, consumer: NamesInteractor.NamesConsumer) {
        executor.execute {
            when(val resource = repository.searhNames(expression)) {
                is Resource.Error -> {
                    consumer.consume(null, resource.message)
                }
                is Resource.Success -> {
                    consumer.consume(resource.data, null )
                }
            }
        }
    }
}