package com.fjoglar.composechallenge.bloom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjoglar.composechallenge.bloom.ui.screens.LoginScreen
import com.fjoglar.composechallenge.bloom.ui.screens.WelcomeScreen
import com.fjoglar.composechallenge.bloom.ui.screens.home.HomeScreen

@Composable
fun BloomNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen { navController.navigate("login") } }
        composable("login") { LoginScreen { navController.navigate("home") } }
        composable("home") { HomeScreen() }
    }
}