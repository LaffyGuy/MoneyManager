package com.projectcode.theme.previews

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

private const val LongDimension = 800
private const val ShortDimension = 400

@Preview(showBackground = true, heightDp = LongDimension, widthDp = ShortDimension)
@Preview(showBackground = true, heightDp = ShortDimension, widthDp = LongDimension)
@Preview(showBackground = true, heightDp = LongDimension, widthDp = ShortDimension, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true, heightDp = ShortDimension, widthDp = LongDimension, uiMode = Configuration.UI_MODE_NIGHT_YES)
annotation class ScreenPreview