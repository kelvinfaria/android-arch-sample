package com.kelvinfaria.costumer.authentication.login.presentation

import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.kelvinfaria.costumer.authentication.R
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class LoginFragment : Fragment(R.layout.fragment_login) {

    private val viewModel: LoginViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (viewModel.a) {
            val request = NavDeepLinkRequest.Builder
                .fromUri("app-costumer://com.kelvinfaria.costumer/homeFragment".toUri())
                .build()
            findNavController().navigate(request)
        }
    }
}