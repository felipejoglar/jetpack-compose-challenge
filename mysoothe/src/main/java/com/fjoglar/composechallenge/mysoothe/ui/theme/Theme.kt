package com.fjoglar.composechallenge.mysoothe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = White,
    secondary = Rust300,
    background = Gray900,
    surface = White150,
    onPrimary = Gray900,
    onSecondary = Gray900,
    onBackground = Taupe100,
    onSurface = White800,
)

private val LightColorPalette = darkColors(
    primary = Gray900,
    secondary = Rust600,
    background = Taupe100,
    surface = White850,
    onPrimary = White,
    onSecondary = White,
    onBackground = Taupe800,
    onSurface = Gray800,
)

@Composable
fun MySootheTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
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