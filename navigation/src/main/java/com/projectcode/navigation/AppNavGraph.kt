package com.projectcode.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.projectcode.feature.init.presentation.InitScreen
import com.projectcode.feature.sign_in.presentation.SignInScreen

fun NavGraphBuilder.buildAppNavGraph(navController: NavController) {
    composable<InitRoute> {
        InitScreen(
            onLaunchSignInScreen = {
                navController.navigate(SignInRoute) {
                    popUpTo(id = 0)
                }
            }
        )
    }
    composable<SignInRoute> { SignInScreen() }
}