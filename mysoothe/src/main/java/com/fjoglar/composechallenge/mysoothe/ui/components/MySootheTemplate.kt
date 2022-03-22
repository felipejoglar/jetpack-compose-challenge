package com.fjoglar.composechallenge.mysoothe.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.mysoothe.ui.screens.WelcomeScreen
import com.fjoglar.composechallenge.mysoothe.ui.theme.MySootheTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MySootheTemplate(
    content: @Composable () -> Unit
) {
    MySootheTheme {
        val systemUiController = rememberSystemUiController()

        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = !isSystemInDarkTheme()
        )

        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.navigationBarsPadding()
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
private fun MySootheTemplatePreview() {
    MySootheTemplate {
        WelcomeScreen()
    }
}