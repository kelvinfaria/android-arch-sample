package com.kelvinfaria.costumer.authentication.login.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kelvinfaria.costumer.authentication.login.domain.LoginUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

internal class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    var error: Boolean = false

    init {
        request()
    }

    private fun request() {
        viewModelScope.launch {
            loginUseCase()
                .catch { Log.e("LoginViewModel", it.message.toString())}
                .collect { error = false }
        }
    }
}