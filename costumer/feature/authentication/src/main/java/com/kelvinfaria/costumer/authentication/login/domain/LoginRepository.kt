package com.kelvinfaria.costumer.authentication.login.domain

import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun login(): Flow<Unit>
}