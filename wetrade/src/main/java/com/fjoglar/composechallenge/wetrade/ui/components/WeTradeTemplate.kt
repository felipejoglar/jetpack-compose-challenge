package com.fjoglar.composechallenge.wetrade.ui.components

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.wetrade.ui.theme.WeTradeTheme

@Composable
fun WeTradeTemplate(
    content: @Composable () -> Unit,
) {
    WeTradeTheme {
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
    WeTradeTemplate {
        Text(text = "Hello World!")
    }
}