package com.projectcode.feature.init.domain.exceptions

import com.projectcode.feature.init.domain.resources.InitStringProvider
import com.projectcode.moneymanager.essentials.exceptions.base.AppException
import com.projectcode.moneymanager.essentials.exceptions.base.WithLocalizedMessage
import com.projectcode.moneymanager.essentials.resources.StringProviderStore


abstract class InitAppException(
    message: String,
    cause: Throwable? = null
): AppException(message, cause), WithLocalizedMessage {
    override fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String {
        return getLocalizedErrorMessage(stringProviderStore<InitStringProvider>())
    }

    abstract fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String

}

class DeviceIsRootedException: InitAppException("Device is rooted") {
    override fun getLocalizedErrorMessage(stringProvider: InitStringProvider): String {
        return stringProvider.deviceIsRootedErrorMessage
    }
}