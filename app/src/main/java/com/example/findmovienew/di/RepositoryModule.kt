package com.example.findmovienew.di

import com.example.findmovienew.data.HistoryRepositoryImpl
import com.example.findmovienew.data.MoviesRepositoryImpl
import com.example.findmovienew.data.NamesRepositoryImpl
import com.example.findmovienew.data.converters.MovieCastConverter
import com.example.findmovienew.data.converters.MovieDbConvertor
import com.example.findmovienew.domain.api.MoviesRepository
import com.example.findmovienew.domain.api.NamesRepository
import com.example.findmovienew.domain.db.HistoryRepository
import org.koin.dsl.module

val repositoryModule = module {

    factory { MovieCastConverter() }

    single<MoviesRepository> {
        MoviesRepositoryImpl(get(), get(), get(), get())
    }

    single<NamesRepository> {
        NamesRepositoryImpl(get())
    }

    factory { MovieDbConvertor() }

    single<HistoryRepository> {
        HistoryRepositoryImpl(get(), get())
    }

}
