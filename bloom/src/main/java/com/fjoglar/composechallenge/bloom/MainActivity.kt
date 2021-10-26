package com.fjoglar.composechallenge.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.fjoglar.composechallenge.bloom.ui.screens.home.HomeScreen
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()

            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = MaterialTheme.colors.isLight
            )

            BloomTheme {
                HomeScreen()
            }
        }
    }
}