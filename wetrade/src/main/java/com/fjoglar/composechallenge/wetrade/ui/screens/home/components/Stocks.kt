package com.fjoglar.composechallenge.wetrade.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.wetrade.data.Repository
import com.fjoglar.composechallenge.wetrade.data.model.Stock
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate

@Composable
fun Stocks(
    stocks: List<Stock>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            Text(
                text = "Positions",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .paddingFromBaseline(top = 40.dp, bottom = 24.dp),
                style = MaterialTheme.typography.subtitle1
            )
        }
        items(stocks) { stock ->
            Column {
                Divider()
                StockItem(stock = stock)
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
private fun HomeContentPreview() {
    WeTradeTemplate {
        Surface {
            Stocks(stocks = Repository.stocks)
        }
    }
}