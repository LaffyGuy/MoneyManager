package com.projectcode.navigation.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import com.projectcode.core.navigation_dsl.ConfiguredScreen
import com.projectcode.core.navigation_dsl.ScreenScope
import com.projectcode.navigation.Route
import kotlin.reflect.KClass

interface ExtendedNavStore {

    val screen: ConfiguredScreen

    fun onBackStackChanged(backStack: List<NavBackStackEntry>)

    fun <T: Route> registerConfiguration(
        routeClass: KClass<T>,
        content: ScreenScope.(T) -> Unit
    )

    @Composable
    fun <T: Route> Content(route: T, id: String)

}