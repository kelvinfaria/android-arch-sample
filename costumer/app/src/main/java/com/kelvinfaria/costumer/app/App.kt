package com.kelvinfaria.costumer.app

import android.app.Application
import com.kelvinfaria.corearch.koin.KoinLifecycleCallbacks
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


internal class App : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(KoinLifecycleCallbacks())
        startKoin {
            modules(

            ).androidContext(applicationContext)
        }
    }
}
