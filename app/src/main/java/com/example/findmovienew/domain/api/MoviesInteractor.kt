package com.example.findmovienew.domain.api

import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.domain.models.MovieCast
import com.example.findmovienew.domain.models.MovieDetails

interface MoviesInteractor {
    fun searchMovies(expression: String, consumer: MoviesConsumer)
    fun getMoviesDetails(movieId: String, consumer: MovieDetailsConsumer)
    fun getMovieCast(movieId: String, consumer: MovieCastConsumer)

    interface MoviesConsumer {
        fun consume(foundMovies: List<Movie>?, errorMessage: String?)
    }

    interface MovieDetailsConsumer {
        fun consume(movieDetails: MovieDetails?, errorMessage: String?)
    }

    interface MovieCastConsumer {
        fun consume(movieCast: MovieCast?, errorMessage: String?)
    }
}
