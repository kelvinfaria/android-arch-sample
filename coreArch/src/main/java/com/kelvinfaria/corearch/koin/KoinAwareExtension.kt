package com.kelvinfaria.corearch.koin

import org.koin.core.module.Module

fun KoinAware.modules(
    vararg modules: Module,
    keepAfterDestroy: Boolean = true
) = subModules(modules.asList(), keepAfterDestroy)

private fun KoinAware.subModules(
    modules:List<Module>,
    keepAfterDestroy: Boolean = true
) = lazy {
    ModuleList(modules, keepAfterDestroy)
}