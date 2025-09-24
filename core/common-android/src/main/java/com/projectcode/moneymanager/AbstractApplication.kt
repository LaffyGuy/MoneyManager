package com.projectcode.moneymanager

import android.app.Application
import com.projectcode.moneymanager.essentials.exceptions.mapper.DefaultExceptionToMessageMapper
import com.projectcode.moneymanager.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.projectcode.moneymanager.essentials.logger.Logger
import com.projectcode.moneymanager.essentials.resources.EssentialsStringProvider
import com.projectcode.moneymanager.essentials.resources.StringProvider
import timber.log.Timber
import javax.inject.Inject

abstract class AbstractApplication: Application() {

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var exceptionToMessageMapper: ExceptionToMessageMapper

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Logger.set(logger)
        ExceptionToMessageMapper.set(exceptionToMessageMapper)
    }
}