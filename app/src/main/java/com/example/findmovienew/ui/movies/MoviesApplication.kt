package com.example.findmovienew.ui.movies

import android.app.Application
import com.example.findmovienew.presentation.movies.MoviesSearchPresenter

class MoviesApplication : Application() {
    var moviesSearchPresenter: MoviesSearchPresenter? = null
}