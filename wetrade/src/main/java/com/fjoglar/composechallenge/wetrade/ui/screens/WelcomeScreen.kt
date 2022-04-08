package com.fjoglar.composechallenge.wetrade.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.wetrade.R
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeButton
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeOutlinedButton
import com.fjoglar.composechallenge.wetrade.ui.components.WeTradeTemplate

@Composable
fun WelcomeScreen(
    onLoginClick: () -> Unit = { },
) {
    Box {
        BackgroundImage()
        LogoImage(
            modifier = Modifier
                .align(Alignment.Center)
        )
        ButtonRow(
            onLoginClick = onLoginClick,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
private fun BackgroundImage(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.welcome_bg),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
    )
}

@Composable
private fun LogoImage(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier

    )
}

@Composable
private fun ButtonRow(
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        WeTradeButton(
            text = stringResource(id = R.string.welcome_get_started),
            onClick = { },
            modifier = Modifier.weight(1f)
        )
        WeTradeOutlinedButton(
            text =  stringResource(id = R.string.log_in),
            onClick = onLoginClick,
            modifier = Modifier.weight(1f)
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
        WelcomeScreen()
    }
}