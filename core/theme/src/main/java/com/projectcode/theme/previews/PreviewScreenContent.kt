package com.projectcode.theme.previews

import androidx.compose.runtime.Composable
import com.projectcode.theme.material.MoneyManagerTheme

@Composable
fun PreviewScreenContent(content: @Composable () -> Unit) {
    MoneyManagerTheme {
        content()
    }
}