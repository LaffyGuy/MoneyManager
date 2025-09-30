package com.projectcode.core.navigation_dsl

interface ConfiguredScreen {

    val toolbar: ScreenToolbar

    data object Empty: ConfiguredScreen {
        override val toolbar = ScreenToolbar.Hidden
    }

}