package com.projectcode.feature.sign_in.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SignInScreen() {
   SignInContent()
}

@Composable
fun SignInContent() {
     Box(
         modifier = Modifier.fillMaxSize(),
         contentAlignment = Alignment.Center
     ) {
         Text(
             text = "Sign In Screen",
             fontSize = 24.sp,
             textAlign = TextAlign.Center
         )
     }
}

@Preview(showSystemUi = true)
@Composable
private fun SignInContentPreview() {
    SignInContent()
}