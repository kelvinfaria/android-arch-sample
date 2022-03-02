package com.kelvinfaria.costumer.app

import android.app.Application
import com.kelvinfaria.corearch.koin_provider.ModuleInitializer
import com.kelvinfaria.costumer.authentication.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
//        startKoin(appDeclaration = KoinAppDeclarationProvider.get(this))
//        startKoin {
//            modules(ModuleInitializer.modules.toList()).androidContext(applicationContext)
//        }
        startKoin {
            modules(presentationModule).androidContext(applicationContext)
        }
    }
}

object KoinAppDeclarationProvider {
    fun get(application: Application): KoinAppDeclaration = {
        androidContext(application)
        modules(ModuleInitializer.modules.toList())
    }
}