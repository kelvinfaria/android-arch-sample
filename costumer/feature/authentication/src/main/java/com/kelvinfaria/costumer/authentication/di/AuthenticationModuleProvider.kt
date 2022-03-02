package com.kelvinfaria.costumer.authentication.di

import com.kelvinfaria.costumer.authentication.login.presentation.LoginViewModel
import com.kelvinfaria.corearch.koin_provider.ModuleProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class AuthenticationModuleProvider : ModuleProvider() {
    override val modules: List<Module>
        get() = listOf(dataModule, presentationModule)

    private val dataModule = module {

    }

    private val presentationModule = module {
        viewModel {
            LoginViewModel()
        }
    }
}

val presentationModule = module {
    viewModel {
        LoginViewModel()
    }
}