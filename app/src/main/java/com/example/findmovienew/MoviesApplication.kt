package com.example.findmovienew

import android.app.Application
import com.example.findmovienew.di.dataModule
import com.example.findmovienew.di.interactorModule
import com.example.findmovienew.di.repositoryModule
import com.example.findmovienew.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        GlobalContext.startKoin {
            androidContext(this@MoviesApplication)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule, com.example.findmovienew.di.navigationModule)
        }
    }
}