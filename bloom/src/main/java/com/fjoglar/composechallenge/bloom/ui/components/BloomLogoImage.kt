package com.fjoglar.composechallenge.bloom.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun BloomLogoImage(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(id = R.string.app_name),
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun BloomLogoImagePreview() {
    BloomTheme {
        BloomLogoImage()
    }
}