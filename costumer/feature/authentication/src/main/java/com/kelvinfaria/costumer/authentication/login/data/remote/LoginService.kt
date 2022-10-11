package com.kelvinfaria.costumer.authentication.login.data.remote

import retrofit2.http.POST

internal interface LoginService {

    @POST("test")
    suspend fun login(): Unit
}