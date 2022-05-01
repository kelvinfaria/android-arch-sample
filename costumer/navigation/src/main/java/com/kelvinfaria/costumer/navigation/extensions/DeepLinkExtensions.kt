package com.kelvinfaria.costumer.navigation.extensions

import androidx.core.net.toUri
import androidx.navigation.NavDeepLinkRequest

fun String.buildDeeplinkRequest() = NavDeepLinkRequest.Builder
    .fromUri(this.toUri())
    .build()

