package com.kelvinfaria.costumer.authentication.login.domain

import kotlinx.coroutines.flow.Flow

internal interface LoginRepository {
    fun login(): Flow<Unit>
}