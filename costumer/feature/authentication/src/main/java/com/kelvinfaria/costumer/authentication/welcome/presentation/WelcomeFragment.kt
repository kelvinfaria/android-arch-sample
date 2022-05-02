package com.kelvinfaria.costumer.authentication.welcome.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kelvinfaria.costumer.authentication.databinding.FragmentWelcomeBinding

internal class WelcomeFragment : Fragment() {

    private val binding by lazy { FragmentWelcomeBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.navigateToLoginFragment())
        }
    }
}
