package com.projectcode.moneymanager.essentials.exceptions.base

import com.projectcode.moneymanager.essentials.resources.StringProviderStore

interface WithLocalizedMessage {

    fun getLocalizedErrorMessage(stringProviderStore: StringProviderStore): String

}