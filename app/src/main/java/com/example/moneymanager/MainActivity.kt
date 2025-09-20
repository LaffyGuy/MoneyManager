package com.example.moneymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.essentials.logger.Logger
import com.example.moneymanager.ui.theme.MoneyManagerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Logger.d("Hello ahahahhaha")
        logger.d("Hello hilt logger")

        enableEdgeToEdge()
        setContent {
            MoneyManagerTheme {

            }
        }
    }
}