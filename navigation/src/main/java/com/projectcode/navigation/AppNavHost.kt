package com.projectcode.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    startDestination: Route = InitRoute,
    navGraphBuilder: NavGraphBuilder.() -> Unit = {},
) {
    val navController = rememberNavController()
    val navGraph = remember {
        navController.createGraph(startDestination) {
            buildAppNavGraph(navController)
            navGraphBuilder()
        }
    }

    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            navController = navController,
            graph = navGraph
        )
    }

}