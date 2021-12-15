package com.fjoglar.composechallenge.mysoothe.ui.components

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.mysoothe.ui.screens.WelcomeScreen
import com.fjoglar.composechallenge.mysoothe.ui.theme.MySootheTheme

@Composable
fun MySootheTemplate(
    content: @Composable () -> Unit
) {
    MySootheTheme {
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
private fun MySootheTemplatePreview() {
    MySootheTemplate {
        WelcomeScreen()
    }
}