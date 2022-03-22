package com.fjoglar.composechallenge.bloom.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.ui.components.BloomTemplate
import com.fjoglar.composechallenge.bloom.ui.screens.home.components.BloomBottomNavigation

@Composable
fun HomeScreen() {
    var selectedItem by rememberSaveable { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BloomBottomNavigation(
                selectedItem = selectedItem,
                onItemClick = { index -> selectedItem = index }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedItem) {
                0 -> HomeContent()
                1 -> PageContent(title = stringResource(id = R.string.home_menu_favorites))
                2 -> PageContent(title = stringResource(id = R.string.home_menu_profile))
                3 -> PageContent(title = stringResource(id = R.string.home_menu_cart))
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
    BloomTemplate {
        HomeScreen()
    }
}