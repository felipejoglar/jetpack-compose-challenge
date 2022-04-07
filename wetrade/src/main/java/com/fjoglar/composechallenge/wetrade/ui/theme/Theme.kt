package com.fjoglar.composechallenge.wetrade.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Yellow,
    background = Purple,
    surface = White,
    onPrimary = Gray900,
    onBackground = White,
    onSurface = Gray900,
)

private val DarkColorPalette = darkColors(
    primary = Yellow,
    background = Gray900,
    surface = Gray700,
    onPrimary = Gray900,
    onBackground = White,
    onSurface = White,
)

@Composable
fun WeTradeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}