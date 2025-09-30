package com.projectcode.navigation.base

import androidx.compose.runtime.Composable
import com.projectcode.core.navigation_dsl.ScreenScope
import com.projectcode.navigation.Route
import kotlin.reflect.KClass

interface ExtendedNavGraphBuilder {

    fun <T: Route> composable(
        routeClass: KClass<T>,
        content:  ScreenScope.(T) -> Unit
    )

}

inline fun <reified T: Route> ExtendedNavGraphBuilder.composable(
    noinline content:  ScreenScope.(T) -> Unit
) = composable(T::class, content)