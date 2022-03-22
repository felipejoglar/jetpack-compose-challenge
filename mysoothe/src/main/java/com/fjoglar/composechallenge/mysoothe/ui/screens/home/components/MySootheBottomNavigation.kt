package com.fjoglar.composechallenge.mysoothe.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.model.BottomNavigationMenuItem
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.model.getMenuItems

@Composable
fun MySootheBottomNavigation(
    items: List<BottomNavigationMenuItem> = getMenuItems(),
    selectedItem: Int = 0,
    onItemClick: (Int) -> Unit = { _ -> },
) {
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
                onClick = { onItemClick(index) },
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
private fun MySootheBottomNavigationPreview() {
    MySootheTemplate {
        MySootheBottomNavigation()
    }
}