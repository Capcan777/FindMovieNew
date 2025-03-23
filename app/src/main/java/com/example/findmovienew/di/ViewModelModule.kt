package com.example.findmovienew.di

import com.example.findmovienew.presentation.cast.MoviesCastViewModel
import com.example.findmovienew.presentation.details.AboutViewModel
import com.example.findmovienew.presentation.details.PosterViewModel
import com.example.findmovienew.presentation.movies.MoviesViewModel
import com.example.findmovienew.presentation.names.NamesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        MoviesViewModel(androidContext(), get())
    }

    viewModel {(movieId: String) ->
        AboutViewModel(movieId, get())
    }

    viewModel {(posterUrl: String) ->
        PosterViewModel(posterUrl)
    }

    viewModel { (movieId: String) ->
        MoviesCastViewModel(movieId, get())
    }
    viewModel {
        NamesViewModel(androidContext(), get())
    }

}