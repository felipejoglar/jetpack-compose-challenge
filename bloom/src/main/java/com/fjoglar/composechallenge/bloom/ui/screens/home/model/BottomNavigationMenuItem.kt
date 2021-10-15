package com.fjoglar.composechallenge.bloom.ui.screens.home.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.fjoglar.composechallenge.bloom.R

data class BottomNavigationMenuItem(
    @StringRes val label: Int,
    val icon: ImageVector,
    val position: Int,
)

fun getMenuItems() = listOf(
    BottomNavigationMenuItem(R.string.home_menu_home, Icons.Default.Home, 0),
    BottomNavigationMenuItem(R.string.home_menu_favorites, Icons.Default.FavoriteBorder, 1),
    BottomNavigationMenuItem(R.string.home_menu_profile, Icons.Default.AccountCircle, 2),
    BottomNavigationMenuItem(R.string.home_menu_cart, Icons.Default.ShoppingCart, 3),
)