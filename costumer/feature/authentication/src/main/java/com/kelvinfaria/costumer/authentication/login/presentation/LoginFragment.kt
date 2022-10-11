package com.kelvinfaria.costumer.authentication.login.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kelvinfaria.corearch.koin.KoinAware
import com.kelvinfaria.corearch.koin.modules
import com.kelvinfaria.costumer.authentication.R
import org.koin.android.ext.android.inject
import com.kelvinfaria.costumer.authentication.databinding.FragmentLoginBinding
import com.kelvinfaria.costumer.authentication.login.di.loginModule
import com.kelvinfaria.costumer.authentication.login.navigation.LoginNavigation
import org.koin.androidx.viewmodel.ext.android.viewModel

internal class LoginFragment : Fragment(), KoinAware {

    override val subModules by modules(loginModule)
    private val binding by lazy { FragmentLoginBinding.inflate(layoutInflater) }
    private val navigation: LoginNavigation by inject()
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!viewModel.error) {
            findNavController().navigate(navigation.navigateToHome())
        }
    }
}