package com.example.findmovienew.di

import com.example.findmovienew.data.MoviesRepositoryImpl
import com.example.findmovienew.data.NamesRepositoryImpl
import com.example.findmovienew.data.converters.MovieCastConverter
import com.example.findmovienew.domain.api.MoviesRepository
import com.example.findmovienew.domain.api.NamesRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { MovieCastConverter() }

    single<MoviesRepository> {
        MoviesRepositoryImpl(get(), get())
    }

    single<NamesRepository> {
        NamesRepositoryImpl(get())
    }

}
