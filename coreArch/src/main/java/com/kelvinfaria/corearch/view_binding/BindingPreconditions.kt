package com.kelvinfaria.corearch.view_binding

import android.os.Build
import android.os.Looper

internal fun isMainThread(): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        Looper.getMainLooper().isCurrentThread
    } else {
        Looper.myLooper() == Looper.getMainLooper()
    }
}

internal fun checkMainThread(lazyMessage: (() -> Any)? = null) {
    if (!isMainThread()) {
        val message = lazyMessage?.invoke() ?: "This call must be executed on main thread."
        throw IllegalStateException(message.toString())
    }
}
