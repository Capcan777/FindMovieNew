package com.example.findmovienew.domain.impl

import com.example.findmovienew.domain.api.MoviesInteractor
import com.example.findmovienew.domain.api.MoviesRepository
import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.domain.models.MovieCast
import com.example.findmovienew.domain.models.MovieDetails
import com.example.findmovienew.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {

    override fun searchMovies(expression: String): Flow<Pair<List<Movie>?, String?>> {
        return repository.searchMovies(expression).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(result.data, result.message)
                }
            }
        }
    }

    override fun getMoviesDetails(movieId: String): Flow<Pair<MovieDetails?, String?>> {
        return repository.getMovieDetails(movieId).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(result.data, result.message)
                }
            }
        }
    }

    override fun getMovieCast(movieId: String): Flow<Pair<MovieCast?, String?>> {
        return repository.getMovieCast(movieId).map { result ->
            when (result) {
                is Resource.Success -> {
                    Pair(result.data, null)
                }

                is Resource.Error -> {
                    Pair(result.data, result.message)
                }
            }
        }
    }

}
