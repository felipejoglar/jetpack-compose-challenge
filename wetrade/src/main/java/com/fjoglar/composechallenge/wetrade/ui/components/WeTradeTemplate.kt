package com.fjoglar.composechallenge.wetrade.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.wetrade.ui.screens.LoginScreen
import com.fjoglar.composechallenge.wetrade.ui.theme.WeTradeTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun WeTradeTemplate(
    statusBarDarkIcons: Boolean = false,
    content: @Composable () -> Unit,
) {
    WeTradeTheme {
        val systemUiController = rememberSystemUiController()

        systemUiController.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = statusBarDarkIcons
        )

        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier
                .navigationBarsPadding()
        ) {
            content()
        }
    }
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
private fun WeTradeTemplatePreview() {
    WeTradeTemplate {
        LoginScreen()
    }
}