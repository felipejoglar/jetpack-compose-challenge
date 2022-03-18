package com.fjoglar.composechallenge.mysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.screens.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MySootheTemplate {
                LoginScreen()
            }
        }
    }
}