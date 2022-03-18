package com.fjoglar.composechallenge.mysoothe.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.model.getMenuItems

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { MySootheBottomNavigation() },
        floatingActionButton = { PlayFAB() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
    ) {

    }
}

@Composable
fun MySootheBottomNavigation() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = getMenuItems()

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = 16.dp,
    ) {
        items.sortedBy { it.position }.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier.size(18.dp),
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = item.label).uppercase(),
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onBackground,
                    )
                },
                selected = selectedItem == index,
                onClick = { selectedItem = index },
            )
        }
    }
}

@Composable
fun PlayFAB(
    onClick: () -> Unit = {},
) {
    FloatingActionButton(
        backgroundColor = MaterialTheme.colors.primary,
        onClick = onClick,
    ) {
        Icon(
            Icons.Default.PlayArrow,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
        )
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