package com.example.findmovienew.util

import android.content.Context
import com.example.findmovienew.data.MoviesRepositoryImpl
import com.example.findmovienew.data.network.RetrofitNetworkClient
import com.example.findmovienew.domain.api.MoviesInteractor
import com.example.findmovienew.domain.api.MoviesRepository
import com.example.findmovienew.domain.impl.MoviesInteractorImpl
import com.example.findmovienew.presentation.movies.MoviesSearchPresenter
import com.example.findmovienew.presentation.poster.PosterPresenter
import com.example.findmovienew.presentation.movies.MoviesView
import com.example.findmovienew.presentation.poster.PosterView

object Creator {
    private fun getMoveiesRepository(context: Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context: Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoveiesRepository(context))
    }
    fun provideMoviesSearchPresenter(context: Context): MoviesSearchPresenter {
        return MoviesSearchPresenter(context = context)
    }
    fun providePosterPresenter(posterView: PosterView, imageUrl: String): PosterPresenter {
        return PosterPresenter(posterView, imageUrl)
    }
}