package com.fjoglar.composechallenge.bloom.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.ui.components.BloomButton
import com.fjoglar.composechallenge.bloom.ui.components.BloomLogoImage
import com.fjoglar.composechallenge.bloom.ui.components.BloomTextButton
import com.fjoglar.composechallenge.bloom.ui.components.VerticalSpacer
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun WelcomeScreen() {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        BackgroundImage()
        Column {
            VerticalSpacer(height = 72.dp)
            Image(
                painter = painterResource(id = R.drawable.welcome_illos),
                contentDescription = null,
                modifier = Modifier
                    .offset(x = 88.dp)
            )
            VerticalSpacer(height = 48.dp)
            BloomLogoImage(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.welcome_subtitle_label),
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 32.dp)
                    .padding(horizontal = 16.dp)
            )
            VerticalSpacer(height = 40.dp)
            BloomButton(
                text = stringResource(R.string.create_account),
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            VerticalSpacer(height = 8.dp)
            BloomTextButton(
                text = stringResource(R.string.log_in),
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            VerticalSpacer(height = 16.dp)
        }

    }
}

@Composable
private fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.welcome_bg),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Preview(
    name = "Day Mode",
    widthDp = 360,
    heightDp = 640,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    widthDp = 360,
    heightDp = 640,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun WelcomeScreenPreview() {
    BloomTheme {
        WelcomeScreen()
    }
}