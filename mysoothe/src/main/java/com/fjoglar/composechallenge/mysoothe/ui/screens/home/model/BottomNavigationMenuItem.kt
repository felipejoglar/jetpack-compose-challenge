package com.fjoglar.composechallenge.mysoothe.ui.screens.home.model

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.ui.graphics.vector.ImageVector
import com.fjoglar.composechallenge.mysoothe.R

data class BottomNavigationMenuItem(
    @StringRes val label: Int,
    val icon: ImageVector,
    val position: Int,
)

fun getMenuItems() = listOf(
    BottomNavigationMenuItem(R.string.home_menu_home, Icons.Default.Spa, 0),
    BottomNavigationMenuItem(R.string.home_menu_profile, Icons.Default.AccountCircle, 1),
)