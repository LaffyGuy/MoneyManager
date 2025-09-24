package com.projectcode.moneymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.projectcode.feature.init.presentation.InitScreen
import com.projectcode.moneymanager.essentials.exceptions.base.UnknownException
import com.projectcode.moneymanager.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.projectcode.moneymanager.essentials.logger.Logger
import com.projectcode.moneymanager.ui.theme.MoneyManagerTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val message = exceptionToMessageMapper.getLocalizedMessage(UnknownException())
        Logger.d(message)

        enableEdgeToEdge()
        setContent {
            MoneyManagerTheme {
                 InitScreen()
            }
        }
    }
}