package com.fjoglar.composechallenge.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.fjoglar.composechallenge.bloom.ui.components.BloomTemplate
import com.fjoglar.composechallenge.bloom.ui.screens.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BloomTemplate {
                HomeScreen()
            }
        }
    }
}