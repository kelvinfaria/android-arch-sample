package com.kelvinfaria.costumer.authentication.login.data.remote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class LoginRemoteDataSource(private val service: LoginService) {

    fun login(): Flow<Unit> = flow {
        emit(service.login())
    }
}