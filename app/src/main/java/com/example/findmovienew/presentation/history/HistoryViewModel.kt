package com.example.findmovienew.presentation.history

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findmovienew.R
import com.example.findmovienew.domain.db.HistoryInteractor
import com.example.findmovienew.domain.models.Movie
import kotlinx.coroutines.launch

class HistoryViewModel(private val context: Context, private val interactor: HistoryInteractor) :
    ViewModel() {

    private val stateLiveData = MutableLiveData<HistoryState>()
    fun observeState(): LiveData<HistoryState> = stateLiveData

    fun fillData() {
        renderState(HistoryState.Loaging)
        viewModelScope.launch {
            interactor.historyMovies()
                .collect { movies ->
                    processResult(movies)
                }
        }
    }

    private fun processResult(movies: List<Movie>) {
        if (movies.isEmpty()) {
            renderState(HistoryState.Empty(context.getString(R.string.nothing_searched_yet)))
        } else {
            renderState(HistoryState.Content(movies))
        }
    }

    private fun renderState(state: HistoryState) {
        stateLiveData.postValue(state)

    }

}