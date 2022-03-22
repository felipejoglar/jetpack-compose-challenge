package com.fjoglar.composechallenge.bloom.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.bloom.ui.components.BloomTemplate
import com.fjoglar.composechallenge.bloom.ui.screens.home.model.BottomNavigationMenuItem
import com.fjoglar.composechallenge.bloom.ui.screens.home.model.getMenuItems

@Composable
fun BloomBottomNavigation(
    items: List<BottomNavigationMenuItem> = getMenuItems(),
    selectedItem: Int = 0,
    onItemClick: (Int) -> Unit = { _ -> },
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 16.dp,
    ) {
        items.sortedBy { it.position }.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null) },
                label = { Text(stringResource(id = item.label)) },
                selected = selectedItem == index,
                onClick = { onItemClick(index) }
            )
        }
    }
}

@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun BloomBottomNavigationPreview() {
    BloomTemplate {
        BloomBottomNavigation()
    }
}