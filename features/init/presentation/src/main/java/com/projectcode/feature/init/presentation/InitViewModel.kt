package com.projectcode.feature.init.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.projectcode.feature.init.domain.IsAuthorizedUseCase
import com.projectcode.feature.init.domain.KeyFeaturesUseCase
import com.projectcode.feature.init.domain.entities.KeyFeature
import com.projectcode.moneymanager.essentials.LoadResult
import com.projectcode.moneymanager.essentials.exceptions.handler.ExceptionHandler
import com.projectcode.moneymanager.essentials.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class InitViewModel @Inject constructor(
    getKeyFeatureUseCase: KeyFeaturesUseCase,
    private val isAuthorizedUseCase: IsAuthorizedUseCase,
    private val exceptionHandler: ExceptionHandler
): ViewModel() {


    private val vmStateFlow = MutableStateFlow(ViewModelState())

    val stateFlow: StateFlow<LoadResult<State>> = combine(
        getKeyFeatureUseCase.invoke(),
        vmStateFlow
    ) { loadResult, vmState ->
         loadResult.map { keyFeature ->
             State(keyFeature, vmState.isCheckAuthInProgress)
         }
    }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), LoadResult.Loading)

    fun getStarted() {
        viewModelScope.launch {
            try {
                vmStateFlow.update { it.copy(isCheckAuthInProgress = true) }
                val isAuthorized = isAuthorizedUseCase.invoke()
                if (isAuthorized) {

                } else {

                }
            } catch (e: Exception) {
                ensureActive()
                vmStateFlow.update { it.copy(isCheckAuthInProgress = false) }
                exceptionHandler.handlerException(e)
            }
        }
    }

    data class State(
        val keyFeature: KeyFeature,
        val isCheckAuthInProgress: Boolean
    )

    private data class ViewModelState(
        val isCheckAuthInProgress: Boolean = false
    )


}