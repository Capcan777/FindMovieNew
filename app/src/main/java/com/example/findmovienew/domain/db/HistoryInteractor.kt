package com.example.findmovienew.domain.db

import com.example.findmovienew.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface HistoryInteractor {
    fun historyMovies(): Flow<List<Movie>>
}