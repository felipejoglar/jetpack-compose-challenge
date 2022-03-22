package com.fjoglar.composechallenge.mysoothe.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjoglar.composechallenge.mysoothe.ui.screens.LoginScreen
import com.fjoglar.composechallenge.mysoothe.ui.screens.WelcomeScreen
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.HomeScreen

@Composable
fun MySootheNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen { navController.navigate("login") } }
        composable("login") { LoginScreen { navController.navigate("home") } }
        composable("home") { HomeScreen() }
    }
}