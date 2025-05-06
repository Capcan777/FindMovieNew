package com.example.findmovienew.domain.db

import com.example.findmovienew.domain.models.Movie
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    fun historyMovies(): Flow<List<Movie>>
}