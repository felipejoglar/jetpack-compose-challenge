package com.fjoglar.composechallenge.wetrade.ui.screens.home.model

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.fjoglar.composechallenge.wetrade.R
import com.fjoglar.composechallenge.wetrade.ui.screens.home.AccountContent
import com.fjoglar.composechallenge.wetrade.ui.screens.home.components.PageContent

@ExperimentalMaterialApi
sealed class HomeScreenTab(val titleResId: Int, val content: @Composable () -> Unit) {
    object Account :
        HomeScreenTab(titleResId = R.string.home_menu_account, content = {
            AccountContent()
        })

    object Watchlist :
        HomeScreenTab(titleResId = R.string.home_menu_watchlist, content = {
            PageContent(title = stringResource(id = R.string.home_menu_watchlist))
        })

    object Profile :
        HomeScreenTab(titleResId = R.string.home_menu_profile, content = {
            PageContent(title = stringResource(id = R.string.home_menu_profile))
        })
}