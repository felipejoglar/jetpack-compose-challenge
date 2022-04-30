package com.fjoglar.composechallenge.wetrade.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fjoglar.composechallenge.wetrade.data.Repository
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate
import com.fjoglar.composechallenge.wetrade.ui.screens.home.components.Stocks
import com.fjoglar.composechallenge.wetrade.ui.screens.home.model.HomeScreenTab
import com.google.accompanist.systemuicontroller.SystemUiController

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    tabs: List<HomeScreenTab>,
    systemUiController: SystemUiController? = null
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val bottomSheetState by remember {
        mutableStateOf(scaffoldState.bottomSheetState)
    }

    if (!isSystemInDarkTheme()) {
        systemUiController?.setStatusBarColor(
            color = Color.Transparent,
            darkIcons = bottomSheetState.isExpanded
        )
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = { Stocks(stocks = Repository.stocks) },
        sheetPeekHeight = 64.dp,
        sheetShape = RectangleShape,
        sheetElevation = 0.dp
    ) { paddingValues ->

        var selectedTab by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .statusBarsPadding()
        ) {
            TabRow(
                selectedTabIndex = selectedTab,
                backgroundColor = MaterialTheme.colors.background,
                indicator = { },
                divider = { },
            ) {
                tabs.forEachIndexed { index, tab ->
                    Tab(
                        text = {
                            Text(
                                text = stringResource(id = tab.titleResId).uppercase(),
                                style = MaterialTheme.typography.button.copy(fontSize = 12.sp)
                            )
                        },
                        selected = selectedTab == index,
                        onClick = { selectedTab = index }
                    )
                }
            }
            tabs[selectedTab].content()
        }
    }
}



@ExperimentalMaterialApi
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
private fun WelcomeScreenPreview() {
    WeTradeTemplate {
        val tabs = listOf(
            HomeScreenTab.Account,
            HomeScreenTab.Watchlist,
            HomeScreenTab.Profile,
        )
        HomeScreen(tabs = tabs)
    }
}