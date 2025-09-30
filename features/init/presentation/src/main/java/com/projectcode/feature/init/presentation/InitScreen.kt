package com.projectcode.feature.init.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.projectcode.core.navigation_dsl.ScreenScope
import com.projectcode.core.navigation_dsl.ScreenToolbar
import com.projectcode.theme.MediumVerticalSpace
import com.projectcode.feature.init.domain.entities.KeyFeature
import com.projectcode.feature.init.presentation.InitViewModel.*
import com.projectcode.moneymanager.essentials.entities.ImageSource
import com.projectcode.theme.Dimens
import com.projectcode.theme.components.ContainerView
import com.projectcode.theme.components.ImageView
import com.projectcode.theme.components.ProgressButton

fun ScreenScope.initScreen(
    onLaunchSignInScreen: () -> Unit
) {
    toolbar = ScreenToolbar.Hidden
    content {
        val viewModel: InitViewModel = hiltViewModel()
        val loadResult by viewModel.stateFlow.collectAsStateWithLifecycle()
        val effects by viewModel.effectsFlow.collectAsStateWithLifecycle()
        LaunchedEffect(effects.launchSignInScreen) {
            if (effects.launchSignInScreen != null) {
                viewModel.onLaunchSignInEffectProcessed()
                onLaunchSignInScreen()
            }
        }

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
}

@Composable
fun InitContent(
    state: State,
    onGetStartedAction: () -> Unit
) {
    val configuration = LocalConfiguration.current
    if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        InitPortraitContent(
            state = state,
            onGetStartedAction = onGetStartedAction
        )
    } else {
        InitLandscapeContent(
            state = state,
            onGetStartedAction = onGetStartedAction
        )
    }
}

@Composable
fun InitPortraitContent(
    state: State,
    onGetStartedAction: () -> Unit
) {
     Column(
         modifier = Modifier
             .fillMaxSize()
             .padding(Dimens.MediumPadding),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
     ) {
         Text(
             text = state.keyFeature.title,
             style = MaterialTheme.typography.titleLarge,
             textAlign = TextAlign.Center
         )
         MediumVerticalSpace()
         ImageView(
             imageSource = state.keyFeature.image,
             modifier = Modifier.size(Dimens.LargeImageSize)
         )
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

@Composable
fun InitLandscapeContent(
    state: State,
    onGetStartedAction: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(Dimens.MediumPadding)
                .weight(1f),
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
        ImageView(
            imageSource = state.keyFeature.image,
            modifier = Modifier
                .wrapContentSize()
                .size(Dimens.LargeImageSize)
                .weight(1f)
        )
    }
}

@Preview(showBackground = true, widthDp = 800, heightDp = 400)
@Composable
private fun InitContentPreview() {
    InitContent(
        State(
            keyFeature = KeyFeature(0, "Title", "Description", ImageSource.Empty),
            isCheckAuthInProgress = false
        ),
        onGetStartedAction = {}
    )

}