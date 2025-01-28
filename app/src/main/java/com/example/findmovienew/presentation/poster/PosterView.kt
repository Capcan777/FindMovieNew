package com.example.findmovienew.presentation.poster

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface PosterView : MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setupPosterImage(url: String)
}