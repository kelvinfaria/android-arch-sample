package com.kelvinfaria.costumer.navigation.feature.authentication.login

import androidx.navigation.NavDeepLinkRequest
import com.kelvinfaria.costumer.authentication.login.navigation.LoginNavigation
import com.kelvinfaria.costumer.navigation.extensions.buildDeeplinkRequest
import com.kelvinfaria.costumer.navigation.feature.home.HOME_FRAGMENT_DEEP_LINK

internal class LoginNavigationImpl : LoginNavigation {
    override fun navigateToHome(): NavDeepLinkRequest =
        HOME_FRAGMENT_DEEP_LINK.buildDeeplinkRequest()
}