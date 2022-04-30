package com.fjoglar.composechallenge.wetrade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate
import com.fjoglar.composechallenge.wetrade.ui.screens.home.HomeScreen
import com.fjoglar.composechallenge.wetrade.ui.screens.home.model.HomeScreenTab

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            WeTradeTemplate { systemUiController ->

                val tabs = listOf(
                    HomeScreenTab.Account,
                    HomeScreenTab.Watchlist,
                    HomeScreenTab.Profile,
                )

                HomeScreen(
                    tabs = tabs,
                    systemUiController = systemUiController
                )
            }
        }
    }
}