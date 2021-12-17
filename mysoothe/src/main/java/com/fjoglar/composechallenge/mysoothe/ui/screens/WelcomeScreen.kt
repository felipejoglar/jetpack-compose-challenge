package com.fjoglar.composechallenge.mysoothe.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.mysoothe.R
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheButton
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheLogoImage
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.components.VerticalSpacer

@Composable
fun WelcomeScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        BackgroundImage()
        Column {
            MySootheLogoImage(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            VerticalSpacer(height = 32.dp)
            MySootheButton(
                text = stringResource(id = R.string.sign_up),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            VerticalSpacer(height = 8.dp)
            MySootheButton(
                text = stringResource(id = R.string.log_in),
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
private fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.welcome_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
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
    MySootheTemplate {
        WelcomeScreen()
    }
}