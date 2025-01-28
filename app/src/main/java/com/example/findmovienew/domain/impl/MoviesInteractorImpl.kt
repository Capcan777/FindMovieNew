package com.example.findmovienew.domain.impl

import com.example.findmovienew.data.NetworkClient
import com.example.findmovienew.data.dto.MoviesSearchRequest
import com.example.findmovienew.domain.api.MoviesInteractor
import com.example.findmovienew.domain.api.MoviesRepository
import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.util.Resource
import java.util.concurrent.Executors

class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor  {

        private val executor = Executors.newCachedThreadPool()
    override fun searchMovies(expression: String, consumer: MoviesInteractor.MoviesConsumer) {
        executor.execute {
            when(val resource = repository.searchMovies(expression)) {
                is Resource.Success -> { consumer.consume(resource.data, null)}
                is Resource.Error -> { consumer.consume(null, resource.message)}
            }
        }
    }
}