package com.fjoglar.composechallenge.wetrade.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.wetrade.data.Repository
import com.fjoglar.composechallenge.wetrade.data.model.Stock
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate
import com.fjoglar.composechallenge.wetrade.ui.theme.Green
import com.fjoglar.composechallenge.wetrade.ui.theme.Red

@Composable
fun StockItem(
    stock: Stock,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = stock.price,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
            )

            Text(
                text = stock.percentDelta,
                style = MaterialTheme.typography.body1,
                color = stock.color,
                modifier = Modifier
                    .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 24.dp)
        ) {
            Text(
                text = stock.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
            )

            Text(
                text = stock.company,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .paddingFromBaseline(top = 16.dp, bottom = 16.dp)
            )
        }

        Image(
            painter = painterResource(id = stock.graph),
            contentDescription = null,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

private val Stock.color: Color
    get() = if (percentDelta.contains("-")) Red else Green


@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun WeTradeButtonPreview() {
    WeTradeTemplate {
        StockItem(
            stock = Repository.stocks.first(),
            modifier = Modifier.padding(16.dp)
        )
    }
}