package com.projectcode.moneymanager.essentials.exceptions.base

import com.projectcode.moneymanager.essentials.resources.EssentialsStringProvider
import com.projectcode.moneymanager.essentials.resources.StringProviderStore

abstract class AppException(
    message: String,
    cause: Throwable? = null
): Exception(message, cause)

abstract class CoreAppException(
    message: String,
    cause: Throwable? = null
): AppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
         return getLocalizedErrorMessage(stringProviderStore<EssentialsStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: EssentialsStringProvider): String

}

class UnknownException: CoreAppException("Unknown exception"), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProvider: EssentialsStringProvider): String {
        return stringProvider.unknownErrorMessage
    }
}

