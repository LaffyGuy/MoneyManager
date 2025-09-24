package com.projectcode.feature.init.domain

import com.projectcode.moneymanager.essentials.exceptions.base.UnknownException
import kotlinx.coroutines.delay
import javax.inject.Inject

class IsAuthorizedUseCase @Inject constructor() {

    suspend fun invoke(): Boolean {
        delay(2000)
        throw UnknownException()
    }

}