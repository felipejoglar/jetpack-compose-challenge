package com.fjoglar.composechallenge.bloom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.fjoglar.composechallenge.bloom.ui.screens.LoginScreen
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BloomTheme {
                LoginScreen()
            }
        }
    }
}