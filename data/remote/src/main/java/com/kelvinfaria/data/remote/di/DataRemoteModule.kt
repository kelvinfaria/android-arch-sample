package com.kelvinfaria.data.remote.di

import com.kelvinfaria.data.remote.BuildConfig
import com.kelvinfaria.data.remote.WebServiceFactory.provideOkHttpClient
import com.kelvinfaria.data.remote.WebServiceFactory.provideRetrofit
import org.koin.dsl.module

val dataRemoteModule = module {
    single { (baseUrl: String) ->
        provideRetrofit(
            okHttpClient = provideOkHttpClient(),
            baseUrl = baseUrl
        )
    }
}