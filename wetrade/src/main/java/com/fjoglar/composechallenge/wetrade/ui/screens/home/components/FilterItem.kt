package com.fjoglar.composechallenge.wetrade.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.wetrade.R
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate

@Composable
fun FilterItem(
    filter: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    OutlinedButton(
        onClick = { onClick(filter) },
        shape = RoundedCornerShape(percent = 50),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent,
            contentColor = MaterialTheme.colors.onBackground
        ),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
        modifier = modifier
            .height(40.dp),
    ) {
        Row {
            Text(
                text = filter,
                style = MaterialTheme.typography.body1,
            )
            if (filter == stringResource(id = R.string.home_account_filter_week)) {
                Icon(
                    imageVector = Icons.Default.ExpandMore,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
            }
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
private fun WeTradeOutlinedButtonPreview() {
    WeTradeTemplate {
        FilterItem(
            filter = "Filter",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(
    name = "Day Mode with Icon",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode with Icon",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun WeTradeOutlinedButtonIconPreview() {
    WeTradeTemplate {
        FilterItem(
            filter = "Week",
            modifier = Modifier.padding(16.dp)
        )
    }
}