package com.fjoglar.composechallenge.wetrade.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjoglar.composechallenge.wetrade.ui.screens.LoginScreen
import com.fjoglar.composechallenge.wetrade.ui.screens.WelcomeScreen
import com.fjoglar.composechallenge.wetrade.ui.screens.home.HomeScreen
import com.fjoglar.composechallenge.wetrade.ui.screens.home.model.HomeScreenTab
import com.google.accompanist.systemuicontroller.SystemUiController

@ExperimentalMaterialApi
@Composable
fun WeTradeNavigation(
    homeScreenTabs: List<HomeScreenTab>,
    systemUiController: SystemUiController,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen { navController.navigate("login") } }
        composable("login") { LoginScreen { navController.navigate("home") } }
        composable("home") { HomeScreen(
            tabs = homeScreenTabs,
            systemUiController = systemUiController
        ) }
    }
}