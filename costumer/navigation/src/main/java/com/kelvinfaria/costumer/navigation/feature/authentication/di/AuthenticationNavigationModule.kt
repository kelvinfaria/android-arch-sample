package com.kelvinfaria.costumer.navigation.feature.authentication.di

import com.kelvinfaria.costumer.authentication.login.navigation.LoginNavigation
import com.kelvinfaria.costumer.navigation.feature.authentication.login.LoginNavigationImpl
import org.koin.dsl.module

val authenticationNavigationModule = module {

    factory<LoginNavigation> {
        LoginNavigationImpl()
    }
}