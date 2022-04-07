package com.fjoglar.composechallenge.wetrade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate
import com.fjoglar.composechallenge.wetrade.ui.theme.WeTradeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeTradeTemplate {
                Greeting("Android")
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}