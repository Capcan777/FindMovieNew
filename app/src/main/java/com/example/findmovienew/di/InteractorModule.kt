package com.example.findmovienew.di

import com.example.findmovienew.domain.api.MoviesInteractor
import com.example.findmovienew.domain.api.NamesInteractor
import com.example.findmovienew.domain.db.HistoryInteractor
import com.example.findmovienew.domain.impl.HistoryInteractorImpl
import com.example.findmovienew.domain.impl.MoviesInteractorImpl
import com.example.findmovienew.domain.impl.NamesInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<MoviesInteractor> {
        MoviesInteractorImpl(get())
    }
    single<NamesInteractor> {
        NamesInteractorImpl(get())
    }

    single<HistoryInteractor> {
        HistoryInteractorImpl(get())
    }
}