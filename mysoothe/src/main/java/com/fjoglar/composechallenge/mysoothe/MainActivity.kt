package com.fjoglar.composechallenge.mysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.fjoglar.composechallenge.mysoothe.navigation.MySootheNavigation
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MySootheTemplate {
                MySootheNavigation()
            }
        }
    }
}