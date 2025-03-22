package com.example.findmovienew.di

import com.example.findmovienew.core.navigation.Router
import com.example.findmovienew.core.navigation.RouterImpl
import org.koin.dsl.module
import kotlin.math.sin

val navigationModule = module {
    val router = RouterImpl()

    single<Router> { router }
    single { router.navigatorHolder }

}