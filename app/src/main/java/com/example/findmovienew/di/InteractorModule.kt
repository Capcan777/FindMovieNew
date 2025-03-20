package com.example.findmovienew.di

import com.example.findmovienew.domain.api.MoviesInteractor
import com.example.findmovienew.domain.impl.MoviesInteractorImpl
import org.koin.dsl.module

val interactorModule = module {
    single<MoviesInteractor> {
        MoviesInteractorImpl(get())
    }
}