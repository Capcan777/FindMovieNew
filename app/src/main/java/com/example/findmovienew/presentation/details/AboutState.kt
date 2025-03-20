package com.example.findmovienew.presentation.details

import com.example.findmovienew.domain.models.MovieDetails

sealed interface AboutState {

    data class Content(val movie: MovieDetails) : AboutState
    data class Error(val message: String) : AboutState
}