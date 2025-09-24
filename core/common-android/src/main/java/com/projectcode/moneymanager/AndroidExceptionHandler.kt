package com.projectcode.moneymanager

import android.content.Context
import android.widget.Toast
import com.projectcode.moneymanager.essentials.exceptions.handler.ExceptionHandler
import com.projectcode.moneymanager.essentials.exceptions.mapper.ExceptionToMessageMapper
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AndroidExceptionHandler @Inject constructor(
    private val exceptionToMessageMapper: ExceptionToMessageMapper,
    @ApplicationContext private val context: Context,
) : ExceptionHandler {
    override fun handlerException(exception: Exception) {
        val message = exceptionToMessageMapper.getLocalizedMessage(exception)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}