package com.projectcode.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.projectcode.moneymanager.essentials.LoadResult
import com.projectcode.moneymanager.essentials.exceptions.base.UnknownException
import com.projectcode.moneymanager.essentials.exceptions.mapper.ExceptionToMessageMapper
import com.projectcode.theme.Dimens
import com.projectcode.theme.MediumVerticalSpace
import com.projectcode.theme.R

@Composable
fun <T> ContainerView(
    loadResult: LoadResult<T>,
    modifier: Modifier = Modifier,
    onTryAgainAction: () -> Unit,
    exceptionToMessageMapper: ExceptionToMessageMapper = ExceptionToMessageMapper,
    content: @Composable (T) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        when (loadResult) {
            is LoadResult.Loading -> CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            is LoadResult.Error -> {
                val message = exceptionToMessageMapper.getLocalizedMessage(loadResult.exception)
                ErrorContainerView(message = message, onTryAgainAction = onTryAgainAction)
            }
            is LoadResult.Success -> {
                content(loadResult.data)
            }
        }
    }
}

@Composable
fun BoxScope.ErrorContainerView(
    message: String,
    onTryAgainAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .align(Alignment.Center)
            .padding(Dimens.MediumPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = message,
            textAlign = TextAlign.Center
        )
        MediumVerticalSpace()
        Button(
            onClick = onTryAgainAction
        ) {
            Text(text = stringResource(R.string.try_again))
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun SuccessContainerView() {
    ContainerView(
        loadResult = LoadResult.Success(data = "Hello World"),
        onTryAgainAction = {}
    ) { value ->
        Text(text = value)
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadingContainerView() {
    ContainerView<String>(
        loadResult = LoadResult.Loading,
        onTryAgainAction = {}
    ) { value ->
        Text(text = value)
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorContainerView() {
    ContainerView(
        loadResult = LoadResult.Error(UnknownException()),
        onTryAgainAction = {}
    ) { value ->
    }
}