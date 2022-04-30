package com.fjoglar.composechallenge.wetrade.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.wetrade.R
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeButton
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate
import com.fjoglar.composechallenge.wetrade.ui.screens.home.components.FilterItem
import com.fjoglar.composechallenge.wetrade.ui.theme.Green

@Composable
fun AccountContent(
    modifier: Modifier = Modifier
) {
    val filterOptions = listOf(
        R.string.home_account_filter_week,
        R.string.home_account_filter_etfs,
        R.string.home_account_filter_stocks,
        R.string.home_account_filter_funds,
        R.string.home_account_filter_crypto,
        R.string.home_account_filter_nfts,
    )

    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.home_account_balance),
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp, bottom = 8.dp)
        )

        Text(
            text = stringResource(id = R.string.home_account_total),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(top = 48.dp, bottom = 24.dp)
        )

        Text(
            text = stringResource(id = R.string.home_account_today_diff),
            style = MaterialTheme.typography.subtitle1,
            color = Green,
            modifier = Modifier
                .paddingFromBaseline(top = 16.dp, bottom = 32.dp)
        )

        WeTradeButton(
            text = stringResource(id = R.string.home_account_transact),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
        ) {
            items(filterOptions) { filter ->
                FilterItem(stringResource(id = filter))
            }
        }

        Image(
            painter = painterResource(id = R.drawable.home_illos),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 32.dp)
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
private fun WelcomeScreenPreview() {
    WeTradeTemplate {
        AccountContent()
    }
}