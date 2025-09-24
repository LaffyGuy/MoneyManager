package com.projectcode.feature.init.domain

import com.projectcode.feature.init.domain.entities.KeyFeature
import com.projectcode.moneymanager.essentials.LoadResult
import com.projectcode.moneymanager.essentials.exceptions.base.UnknownException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class KeyFeaturesUseCase @Inject constructor() {

    fun invoke(): Flow<LoadResult<KeyFeature>> {
        return flow {
            delay(2000)
            emit(LoadResult.Success(KeyFeature(0, "This is pro feature", "This is pro feature description")))
        }
    }
}