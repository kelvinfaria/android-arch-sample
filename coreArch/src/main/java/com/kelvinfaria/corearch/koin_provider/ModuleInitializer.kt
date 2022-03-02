package com.kelvinfaria.corearch.koin_provider

import org.koin.core.module.Module

object ModuleInitializer {

    val modules = mutableSetOf<Module>()

    fun add(vararg modules: Module) {
        ModuleInitializer.modules.addAll(modules)
    }

    fun add(modules: List<Module>) {
        ModuleInitializer.modules.addAll(modules)
    }
}
