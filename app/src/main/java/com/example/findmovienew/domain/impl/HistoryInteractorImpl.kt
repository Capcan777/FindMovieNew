package com.example.findmovienew.domain.impl

import com.example.findmovienew.domain.db.HistoryInteractor
import com.example.findmovienew.domain.db.HistoryRepository
import com.example.findmovienew.domain.models.Movie
import kotlinx.coroutines.flow.Flow

class HistoryInteractorImpl(private val historyRepository: HistoryRepository): HistoryInteractor {
    override fun historyMovies(): Flow<List<Movie>> {
        return historyRepository.historyMovies()
    }
}