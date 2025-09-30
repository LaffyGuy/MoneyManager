package com.projectcode.navigation.base

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.projectcode.core.navigation_dsl.ScreenScope
import com.projectcode.navigation.Route
import kotlin.reflect.KClass

class ExtendedNavGraphBuilderImpl(
    private val navGraphBuilder: NavGraphBuilder,
    private val navStore: ExtendedNavStore
): ExtendedNavGraphBuilder {
    override fun <T : Route> composable(
        routeClass: KClass<T>,
        content:  (ScreenScope.(T) -> Unit),
    ) {
       navStore.registerConfiguration(routeClass, content)
       navGraphBuilder.composable(route = routeClass) { navEntry ->
           val route = navEntry.toRoute<T>(routeClass)
            navStore.Content(route, navEntry.id)
       }
    }
}