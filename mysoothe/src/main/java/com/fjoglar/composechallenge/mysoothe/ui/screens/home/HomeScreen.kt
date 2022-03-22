package com.fjoglar.composechallenge.mysoothe.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.components.MySootheBottomNavigation
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.components.PlayFAB

@Composable
fun HomeScreen() {
    var selectedItem by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            MySootheBottomNavigation(
                selectedItem = selectedItem,
                onItemClick = { index -> selectedItem = index }
            )
        },
        floatingActionButton = { PlayFAB() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedItem) {
                0 -> HomeContent()
                1 -> ProfileContent()
            }
        }
    }
}

@Preview(
    name = "Day Mode",
    widthDp = 360,
    heightDp = 640,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    widthDp = 360,
    heightDp = 640,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun HomeScreenPreview() {
    MySootheTemplate {
        HomeScreen()
    }
}