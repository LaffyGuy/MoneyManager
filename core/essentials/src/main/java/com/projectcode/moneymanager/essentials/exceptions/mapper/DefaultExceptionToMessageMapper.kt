package com.projectcode.moneymanager.essentials.exceptions.mapper

import com.projectcode.moneymanager.essentials.exceptions.base.WithLocalizedMessage
import com.projectcode.moneymanager.essentials.resources.EssentialsStringProvider
import com.projectcode.moneymanager.essentials.resources.StringProviderStore
import javax.inject.Inject

class DefaultExceptionToMessageMapper @Inject constructor(
    private val stringProviderStore: StringProviderStore
) : ExceptionToMessageMapper {

    override fun getLocalizedMessage(exception: Exception): String {
        return if (exception is WithLocalizedMessage) {
            exception.getLocalizedErrorMessage(stringProviderStore)
        } else {
            stringProviderStore<EssentialsStringProvider>().unknownErrorMessage
        }
    }
}