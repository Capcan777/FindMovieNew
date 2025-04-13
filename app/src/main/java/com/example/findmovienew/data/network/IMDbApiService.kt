package com.example.findmovienew.data.network

import com.example.findmovienew.data.dto.MovieCastResponse
import com.example.findmovienew.data.dto.MovieDetailsResponse
import com.example.findmovienew.data.dto.NamesSearchResponse
import com.example.findmovienew.data.dto.MoviesSearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IMDbApiService {
    @GET("/en/API/SearchMovie/k_zcuw1ytf/{expression}")
    suspend fun searchMovies(@Path("expression") expression: String): MoviesSearchResponse

    @GET("/en/API/Title/k_zcuw1ytf/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: String): MovieDetailsResponse

    @GET("/en/API/FullCast/k_zcuw1ytf/{movie_id}")
    suspend fun getFullCast(@Path("movie_id") movieId: String): MovieCastResponse

    @GET("/en/API/SearchName/k_zcuw1ytf/{expression}")
    suspend fun getArtist(@Path("expression") expression: String): NamesSearchResponse
}