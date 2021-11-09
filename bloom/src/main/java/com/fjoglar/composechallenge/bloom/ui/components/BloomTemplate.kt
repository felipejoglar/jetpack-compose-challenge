package com.fjoglar.composechallenge.bloom.ui.components

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.bloom.ui.screens.home.HomeScreen
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BloomTemplate(
    content: @Composable () -> Unit,
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(
        color = Color.Transparent,
        darkIcons = MaterialTheme.colors.isLight
    )

    BloomTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
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
private fun BloomTemplatePreview() {
    BloomTemplate {
        HomeScreen()
    }
}