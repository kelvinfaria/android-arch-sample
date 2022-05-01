package com.kelvinfaria.costumer.authentication.login.di

import com.kelvinfaria.costumer.authentication.login.presentation.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel {
        LoginViewModel()
    }
}