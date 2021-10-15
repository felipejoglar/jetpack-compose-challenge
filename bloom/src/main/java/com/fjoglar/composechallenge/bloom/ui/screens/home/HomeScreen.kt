package com.fjoglar.composechallenge.bloom.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fjoglar.composechallenge.bloom.ui.screens.home.model.getMenuItems
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BloomBottomNavigation() }
    ) { paddingValues ->
        Surface(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun BloomBottomNavigation() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = getMenuItems()

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        items.sortedBy { it.position }.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(stringResource(id = item.label)) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
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
    BloomTheme {
        HomeScreen()
    }
}