package com.example.findmovienew.presentation.movies

import android.content.Context
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import com.example.findmovienew.R
import com.example.findmovienew.domain.api.MoviesInteractor
import com.example.findmovienew.domain.models.Movie
import com.example.findmovienew.util.Creator
import moxy.MvpPresenter

class MoviesSearchPresenter(private val context: Context) : MvpPresenter<MoviesView>() {

    private val moviesInteractor = Creator.provideMoviesInteractor(context)

    companion object {
        private const val SEARCH_DEBOUNCE_DELAY = 2000L
        private val SEARCH_REQUEST_TOKEN = Any()
    }

    private var latestSearchText: String? = null

    //    private val movies = ArrayList<Movie>()
    private val handler = Handler(Looper.getMainLooper())


    override fun onDestroy() {
        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)
    }

    fun searchDebounce(changedText: String) {
        if (latestSearchText == changedText) {
            return
        }
        this.latestSearchText = changedText
        handler.removeCallbacksAndMessages(SEARCH_REQUEST_TOKEN)
        val searchRunnable = Runnable { searchRequest(changedText) }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            handler.postDelayed(searchRunnable, SEARCH_REQUEST_TOKEN, SEARCH_DEBOUNCE_DELAY)
        } else {
            val postTime = SystemClock.uptimeMillis() + SEARCH_DEBOUNCE_DELAY
            handler.postAtTime(searchRunnable, SEARCH_REQUEST_TOKEN, postTime)
        }
    }

    private fun searchRequest(newSearchText: String) {
        if (newSearchText.isNotEmpty()) {
            renderState(MoviesState.Loading)

            moviesInteractor.searchMovies(
                newSearchText,
                object : MoviesInteractor.MoviesConsumer {

                    override fun consume(foundMovies: List<Movie>?, errorMessage: String?) {
                        handler.post {
                            val movies = mutableListOf<Movie>()
                            if (foundMovies != null) {
                                movies.addAll(foundMovies)
                            }
                            when {
                                errorMessage != null -> {
                                    renderState(MoviesState.Error(errorMessage = context.getString(R.string.something_went_wrong)))
                                    viewState.showToast(errorMessage)
                                }

                                movies.isEmpty() -> {
                                    renderState(MoviesState.Empty(message = context.getString(R.string.nothing_found)))
                                }

                                else -> renderState(MoviesState.Content(movies = movies))
                            }
                        }
                    }
                })
        }
    }

    private fun renderState(state: MoviesState) {
        viewState.render(state)
    }

}