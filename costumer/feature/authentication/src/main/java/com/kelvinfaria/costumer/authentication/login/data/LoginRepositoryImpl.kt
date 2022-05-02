package com.kelvinfaria.costumer.authentication.login.data

import com.kelvinfaria.costumer.authentication.login.domain.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

internal class LoginRepositoryImpl(
    private val remoteDataSource: LoginRemoteDataSource,
    private val dispatcher: CoroutineDispatcher = Dispatcher.IO
) : LoginRepository {
    override fun login(): Flow<Unit> =
        remoteDataSource.login()
            .flowOn(dispatcher)
}