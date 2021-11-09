package com.fjoglar.composechallenge.bloom.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.data.Repository
import com.fjoglar.composechallenge.bloom.ui.components.BloomTemplate
import com.fjoglar.composechallenge.bloom.ui.components.BloomTextField
import com.fjoglar.composechallenge.bloom.ui.components.VerticalSpacer
import com.fjoglar.composechallenge.bloom.ui.screens.home.components.PlantItem
import com.fjoglar.composechallenge.bloom.ui.screens.home.components.ThemeItem
import com.fjoglar.composechallenge.bloom.ui.screens.home.model.getMenuItems
import com.fjoglar.composechallenge.bloom.ui.screens.home.model.toHomeGardenItem

@Composable
fun HomeScreen() {
    Scaffold(
        bottomBar = { BloomBottomNavigation() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues),
        ) {
            VerticalSpacer(height = 40.dp)
            SearchTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            BrowseThemesSection()
            HomeGardenSection()
            VerticalSpacer(height = 16.dp)
        }
    }
}

@Composable
private fun BloomBottomNavigation() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = getMenuItems()

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        elevation = 16.dp,
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

@Composable
private fun SearchTextField(
    modifier: Modifier = Modifier,
) {
    var searchQuery by rememberSaveable { mutableStateOf("") }

    BloomTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = stringResource(R.string.home_search_label),
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        modifier = modifier
    )
}

@Composable
private fun BrowseThemesSection() {
    Text(
        text = stringResource(R.string.home_browse_themes_section_title),
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp, bottom = 16.dp)
            .padding(horizontal = 16.dp)
    )
    ThemesList()
}

@Composable
private fun ThemesList(
    modifier: Modifier = Modifier,
) {
    val themes by remember { mutableStateOf(Repository.getThemes()) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .height(136.dp),
    ) {
        items(themes) { theme ->
            ThemeItem(
                theme = theme,
                modifier = Modifier
                    .fillMaxHeight()
            )
        }
    }
}

@Composable
private fun HomeGardenSection() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
            .padding(start = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.home_home_garden_section_title),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .weight(1F)
        )
        IconButton(
            onClick = {},
            modifier = Modifier
                .padding(end = 4.dp)
        ) {
            Icon(
                Icons.Default.FilterList,
                contentDescription = stringResource(R.string.home_home_garden_section_filter),
            )
        }
    }
    HomeGardenList()
}

@Composable
private fun HomeGardenList(
    modifier: Modifier = Modifier,
) {
    var homeGardenItems by remember {
        mutableStateOf(Repository.getPlants().map { it.toHomeGardenItem() })
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth(),
    ) {
        homeGardenItems.forEach { item ->
            PlantItem(
                plant = item.plant,
                checked = item.isSelected,
                onCheckedChanged = {
                    homeGardenItems = homeGardenItems.toMutableList().apply {
                        set(indexOf(item), item.copy(isSelected = it))
                    }
                }
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
    BloomTemplate {
        HomeScreen()
    }
}