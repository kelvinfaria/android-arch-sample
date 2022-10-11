package com.kelvinfaria.data.remote.di

import com.kelvinfaria.data.remote.WebServiceFactory.provideOkHttpClient
import com.kelvinfaria.data.remote.WebServiceFactory.provideRetrofit
import org.koin.dsl.module

fun dataRemoteModule(baseUrl: String) = module {
    single {
        provideRetrofit(
            okHttpClient = provideOkHttpClient(),
            baseUrl = baseUrl
        )
    }
}