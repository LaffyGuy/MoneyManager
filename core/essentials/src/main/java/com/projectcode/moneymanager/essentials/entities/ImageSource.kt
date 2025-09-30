package com.projectcode.moneymanager.essentials.entities

sealed interface ImageSource {

    data object Empty: ImageSource

    data class Remote(val url: String): ImageSource

    data class Local(val uri: String): ImageSource

    data class DrawableRes(val resId: Int): ImageSource

}