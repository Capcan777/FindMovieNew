package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.util.Resource

interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
}
