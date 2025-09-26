package com.projectcode.navigation

import kotlinx.serialization.Serializable

interface Route

@Serializable
data object InitRoute: Route

@Serializable
data object SignInRoute: Route