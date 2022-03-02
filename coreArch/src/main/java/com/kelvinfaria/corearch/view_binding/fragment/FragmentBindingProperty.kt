package com.kelvinfaria.corearch.view_binding.fragment

import android.os.Handler
import android.os.Looper
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import com.kelvinfaria.corearch.view_binding.bind
import com.kelvinfaria.corearch.view_binding.checkMainThread
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Suppress("unused")
inline fun <reified T : ViewBinding> Fragment.viewBinding(): ReadOnlyProperty<Fragment, T> =
    FragmentBindingProperty { fragment -> fragment.requireView().bind(T::class.java) }

class FragmentBindingProperty<T : ViewBinding>(
    private val viewBindingCreator: (Fragment) -> T,
) : ReadOnlyProperty<Fragment, T> {

    private var viewBinding: T? = null
    private val lifecycleObserver = BindingLifecycleObserver()

    @MainThread
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        checkMainThread { "The viewBinding property must be used on main thread." }
        thisRef.viewLifecycleOwner.lifecycle.addObserver(lifecycleObserver)
        return viewBinding ?: viewBindingCreator(thisRef)
            .also { viewBinding = it }
    }

    private inner class BindingLifecycleObserver : DefaultLifecycleObserver {

        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            owner.lifecycle.removeObserver(this)
            // Fragment.viewLifecycleOwner call LifecycleObserver.onDestroy() before Fragment.onDestroyView().
            // That's why we need to postpone reset of the viewBinding
            val mainHandler = Handler(Looper.getMainLooper())
            mainHandler.post {
                viewBinding = null
            }
        }
    }
}
