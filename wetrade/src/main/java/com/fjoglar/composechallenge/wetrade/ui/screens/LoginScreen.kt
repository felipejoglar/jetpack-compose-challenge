package com.fjoglar.composechallenge.wetrade.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.wetrade.R
import com.fjoglar.composechallenge.wetrade.ui.components.*

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = { },
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val focusRequester = FocusRequester()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colors.surface)
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.login_bg),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
            VerticalSpacer(height = 40.dp)

            EmailTextField(
                value = email,
                onValueChange = { email = it },
                keyboardAction = { focusRequester.requestFocus() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
            VerticalSpacer(height = 8.dp)
            PasswordTextField(
                value = password,
                onValueChange = { password = it },
                keyboardAction = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester)
                    .padding(horizontal = 16.dp)
            )
            VerticalSpacer(height = 16.dp)
            WeTradeButton(
                text = stringResource(id = R.string.log_in),
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }

        TitleText()
    }
}

@Composable
private fun TitleText(
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = R.string.login_title),
        style = MaterialTheme.typography.h2,
        color = Color.White,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth()
            .paddingFromBaseline(top = 152.dp)
            .padding(horizontal = 48.dp)
    )
}


@Composable
private fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    WeTradeTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(id = R.string.login_email_hint),
        leadingIcon = { Icon(Icons.Default.MailOutline, contentDescription = null) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next,
        ),
        keyboardActions = KeyboardActions(
            onNext = { keyboardAction() }
        ),
        modifier = modifier
    )
}

@Composable
private fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    WeTradeTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(id = R.string.login_password_hint),
        leadingIcon = { Icon(Icons.Default.Password, contentDescription = null) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Go,
        ),
        keyboardActions = KeyboardActions(
            onGo = { keyboardAction() }
        ),
        visualTransformation = PasswordVisualTransformation(),
        modifier = modifier
    )
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
        LoginScreen()
    }
}