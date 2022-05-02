package com.kelvinfaria.costumer.authentication.login.di

import com.kelvinfaria.costumer.authentication.login.data.repository.LoginRepositoryImpl
import com.kelvinfaria.costumer.authentication.login.data.remote.LoginRemoteDataSource
import com.kelvinfaria.costumer.authentication.login.data.remote.LoginService
import com.kelvinfaria.costumer.authentication.login.domain.LoginUseCase
import com.kelvinfaria.costumer.authentication.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val loginModule = module {

    viewModel {
        LoginViewModel(
            loginUseCase = LoginUseCase(
                repository = LoginRepositoryImpl(
                    remoteDataSource = LoginRemoteDataSource(
                        service = get<Retrofit>().create(LoginService::class.java)
                    )
                )
            )
        )
    }
}