package com.example.findmovienew.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.findmovienew.data.NetworkClient
import com.example.findmovienew.data.dto.MovieCastRequest
import com.example.findmovienew.data.dto.MovieCastResponse
import com.example.findmovienew.data.dto.MovieDetailsRequest
import com.example.findmovienew.data.dto.MoviesSearchRequest
import com.example.findmovienew.data.dto.NamesSearchRequest
import com.example.findmovienew.data.dto.NamesSearchResponse
import com.example.findmovienew.data.dto.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitNetworkClient(
    private val imdbService: IMDbApiService,
    private val context: Context,
) : NetworkClient {

    override suspend fun doRequestSuspend(dto: Any): Response {
        if (isConnected() == false) {
            return Response().apply { resultCode = -1 }
        }
        if ((dto !is MoviesSearchRequest) && (dto !is MovieDetailsRequest) && (dto !is MovieCastRequest) && (dto !is NamesSearchRequest)) {
            return Response().apply { resultCode = 400 }
        }

        return withContext(Dispatchers.IO) {
            try {
                val response = when (dto) {
                    is MoviesSearchRequest -> imdbService.searchMovies(dto.expression)
                    is MovieDetailsRequest -> imdbService.getMovieDetails(dto.movieId)
                    is NamesSearchRequest -> imdbService.getArtist(dto.expression)
                    else -> imdbService.getFullCast((dto as MovieCastRequest).movieId)
                }
                response.apply { resultCode = 200 }
            } catch (e: Throwable) {
                Response().apply { resultCode = 500 }
            }
        }
    }


    private fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
            }
        }
        return false
    }
}

