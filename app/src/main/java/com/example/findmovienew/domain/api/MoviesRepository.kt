package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.domain.models.MovieCast
import com.example.findmovienew.domain.models.MovieDetails
import com.example.findmovienew.util.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun searchMovies(expression: String): Flow<Resource<List<Movie>>>
    fun getMovieDetails(movieId: String): Flow<Resource<MovieDetails>>
    fun getMovieCast(movieId: String): Flow<Resource<MovieCast>>
}
