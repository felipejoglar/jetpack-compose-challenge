package com.fjoglar.composechallenge.mysoothe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fjoglar.composechallenge.mysoothe.ui.screens.WelcomeScreen
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MySootheTemplate {
                WelcomeScreen()
            }
        }
    }
}