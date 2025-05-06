package com.example.findmovienew.presentation.history

import com.example.findmovienew.domain.models.Movie

sealed interface HistoryState {

    object Loaging : HistoryState

    data class Content(
        val movies: List<Movie>
    ) : HistoryState

    data class Empty(val message: String) : HistoryState
}