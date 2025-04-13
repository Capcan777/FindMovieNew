package com.example.findmovienew.data

import com.example.findmovienew.data.converters.MovieCastConverter
import com.example.findmovienew.data.dto.MovieCastRequest
import com.example.findmovienew.data.dto.MovieCastResponse
import com.example.findmovienew.data.dto.MovieDetailsRequest
import com.example.findmovienew.data.dto.MovieDetailsResponse
import com.example.findmovienew.data.dto.MoviesSearchRequest
import com.example.findmovienew.data.dto.MoviesSearchResponse
import com.example.findmovienew.domain.api.MoviesRepository
import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.domain.models.MovieCast
import com.example.findmovienew.domain.models.MovieDetails
import com.example.findmovienew.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MoviesRepositoryImpl(
    private val networkClient: NetworkClient,
    private val movieCastConverter: MovieCastConverter,
) : MoviesRepository {

    override fun searchMovies(expression: String): Flow<Resource<List<Movie>>> = flow {
        val response = networkClient.doRequestSuspend(MoviesSearchRequest(expression))
        when (response.resultCode) {
            -1 -> {
                emit(Resource.Error("Проверьте подключение к интернету"))
            }

            200 -> {
                with(response as MoviesSearchResponse) {
                    val data = results.map {
                        Movie(it.id, it.resultType, it.image, it.title, it.description)
                    }
                    emit(Resource.Success(data))
                }
            }

            else -> {
                emit(Resource.Error("Ошибка сервера"))
            }
        }
    }

    override fun getMovieDetails(movieId: String): Flow<Resource<MovieDetails>> = flow {
        val response = networkClient.doRequestSuspend(MovieDetailsRequest(movieId))
        when (response.resultCode) {
            -1 -> {
                emit(Resource.Error("Проверьте подключение к интернету"))
            }

            200 -> {
                with(response as MovieDetailsResponse) {
                    val data = MovieDetails(
                        id, title, imDbRating ?: "", year,
                        countries, genres, directors, writers, stars, plot
                    )
                    emit(Resource.Success(data))
                }
            }

            else -> {
                emit(Resource.Error("Ошибка сервера"))

            }
        }
    }

    override fun getMovieCast(movieId: String): Flow<Resource<MovieCast>> = flow {
        val response = networkClient.doRequestSuspend(MovieCastRequest(movieId))
        when (response.resultCode) {
            -1 -> {
                emit(Resource.Error("Проверьте подключение к интернету"))
            }

            200 -> {
                val data = movieCastConverter.convert(response as MovieCastResponse)
                emit(Resource.Success(data))
            }

            else -> {
                emit(Resource.Error("Ошибка сервера"))

            }
        }
    }

}
