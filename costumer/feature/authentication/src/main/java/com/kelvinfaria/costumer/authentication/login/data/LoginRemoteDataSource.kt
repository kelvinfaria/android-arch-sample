package com.kelvinfaria.costumer.authentication.login.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class LoginRemoteDataSource() {
    fun login(): Flow<Unit> = flow {
        emit(Unit)
    }
}