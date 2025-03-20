package com.example.findmovienew.presentation.cast

import com.example.findmovienew.core.ui.RVItem
import com.example.findmovienew.domain.models.MovieCastPerson

sealed interface MoviesCastRVItem : RVItem {

    data class HeaderItem(
        val headerText: String,
    ) : MoviesCastRVItem

    data class PersonItem(
        val data: MovieCastPerson,
    ) : MoviesCastRVItem

}