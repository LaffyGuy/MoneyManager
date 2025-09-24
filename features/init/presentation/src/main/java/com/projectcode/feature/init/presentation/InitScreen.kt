package com.projectcode.feature.init.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.projectcode.theme.MediumVerticalSpace
import com.projectcode.feature.init.domain.entities.KeyFeature
import com.projectcode.feature.init.presentation.InitViewModel.*
import com.projectcode.theme.Dimens
import com.projectcode.theme.components.ContainerView
import com.projectcode.theme.components.ProgressButton

@Composable
fun InitScreen() {

    val viewModel: InitViewModel = hiltViewModel()
    val loadResult by viewModel.stateFlow.collectAsStateWithLifecycle()

    ContainerView(
        loadResult = loadResult,
        modifier = Modifier.fillMaxSize(),
        onTryAgainAction = {}
    ) { state ->
        InitContent(
            state = state,
            onGetStartedAction = viewModel::getStarted
        )
    }

}

@Composable
fun InitContent(
    state: State,
    onGetStartedAction: () -> Unit
) {
     Column(
         modifier = Modifier.fillMaxSize().padding(Dimens.MediumPadding),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Text(
             text = state.keyFeature.title,
             style = MaterialTheme.typography.titleLarge,
             textAlign = TextAlign.Center
         )
         MediumVerticalSpace()
         Text(
             text = state.keyFeature.description,
             textAlign = TextAlign.Center
         )
         MediumVerticalSpace()
         ProgressButton(
             isInProgress = state.isCheckAuthInProgress,
             text = "Get Started",
             onClick = onGetStartedAction
         )
     }
}

@Preview(showSystemUi = true)
@Composable
private fun InitContentPreview() {
    InitContent(
        State(
            keyFeature = KeyFeature(0, "Title", "Description"),
            isCheckAuthInProgress = true
        ),
        onGetStartedAction = {}
    )

}