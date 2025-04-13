package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.domain.models.MovieCast
import com.example.findmovienew.domain.models.MovieDetails
import kotlinx.coroutines.flow.Flow

interface MoviesInteractor {
    fun searchMovies(expression: String): Flow<Pair<List<Movie>?, String?>>
    fun getMoviesDetails(movieId: String): Flow<Pair<MovieDetails?, String?>>
    fun getMovieCast(movieId: String): Flow<Pair<MovieCast?, String?>>
}
