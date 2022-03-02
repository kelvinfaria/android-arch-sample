package com.kelvinfaria.corearch.view_binding.view_holder

import androidx.annotation.MainThread
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.kelvinfaria.corearch.view_binding.bind
import com.kelvinfaria.corearch.view_binding.checkMainThread
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

@Suppress("unused")
inline fun <reified T : ViewBinding> ViewHolder.viewBinding(): ReadOnlyProperty<ViewHolder, T> =
    ViewHolderBindingProperty { viewHolder -> viewHolder.itemView.bind(T::class.java) }

class ViewHolderBindingProperty<T : ViewBinding>(
    private val viewBindingCreator: (ViewHolder) -> T,
) : ReadOnlyProperty<ViewHolder, T> {

    private var viewBinding: T? = null

    @MainThread
    override fun getValue(thisRef: ViewHolder, property: KProperty<*>): T {
        checkMainThread { "The viewBinding property must be used on main thread." }
        return viewBinding ?: viewBindingCreator(thisRef)
            .also { viewBinding = it }
    }
}
