package com.fjoglar.composechallenge.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.fjoglar.composechallenge.bloom.navigation.BloomNavigation
import com.fjoglar.composechallenge.bloom.ui.components.BloomTemplate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BloomTemplate {
                BloomNavigation()
            }
        }
    }
}