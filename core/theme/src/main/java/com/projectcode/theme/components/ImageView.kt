package com.projectcode.theme.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import com.projectcode.moneymanager.essentials.entities.ImageSource
import com.projectcode.theme.R
import com.projectcode.theme.Shapes

@Composable
fun ImageView(
    imageSource: ImageSource,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    when(imageSource) {
        is ImageSource.DrawableRes -> DrawableResImageSource(resId = imageSource.resId, modifier = modifier, contentDescription = contentDescription)
        ImageSource.Empty -> EmptyImageView(modifier = modifier, contentDescription = contentDescription)
        is ImageSource.Local -> LocalImageSource(uri = imageSource.uri, modifier = modifier, contentDescription = contentDescription)
        is ImageSource.Remote -> RemoteImageView(imageUrl = imageSource.url, modifier = modifier, contentDescription = contentDescription)
    }

}

@Composable
private fun RemoteImageView(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {

    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier,
        error = {
            EmptyImageView(
                modifier = Modifier.matchParentSize(),
                contentDescription = contentDescription
            )
        }
    )
}

@Composable
fun DrawableResImageSource(
    resId: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    AsyncImage(
        model = resId,
        contentDescription = contentDescription,
        modifier = modifier
    )
}

@Composable
fun LocalImageSource(
    uri: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    AsyncImage(
        model = uri,
        contentDescription = contentDescription,
        modifier = modifier
    )
}

@Composable
fun EmptyImageView(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    Image(
        painter = painterResource(R.drawable.ic_empty_image),
        contentDescription = contentDescription,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.secondaryContainer,
                shape = Shapes.LargeRoundedCornerShape
            )
    )
}

@Preview(showBackground = true)
@Composable
private fun EmptyImageViewPreview() {
    EmptyImageView()
}
