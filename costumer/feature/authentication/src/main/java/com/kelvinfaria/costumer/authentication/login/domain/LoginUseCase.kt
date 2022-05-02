package com.kelvinfaria.costumer.authentication.login.domain

import kotlinx.coroutines.flow.Flow

internal class LoginUseCase(private val repository: LoginRepository) {
    operator fun invoke(): Flow<Unit> = repository.login()
}