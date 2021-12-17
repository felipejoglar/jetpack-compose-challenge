package com.fjoglar.composechallenge.mysoothe.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.mysoothe.R
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheButton
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTextField
import com.fjoglar.composechallenge.mysoothe.ui.components.UrlClickableText
import com.fjoglar.composechallenge.mysoothe.ui.components.VerticalSpacer
import java.util.*

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit = {},
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val focusRequester = FocusRequester()

    BackgroundImage()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.log_in).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 200.dp, bottom = 32.dp)
        )

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
        VerticalSpacer(height = 8.dp)

        MySootheButton(
            text = stringResource(id = R.string.log_in),
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        UrlClickableText(
            text = stringResource(id = R.string.log_in_no_account_label),
            urls = mapOf(stringResource(id = R.string.sign_up) to "http://google.com"),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 32.dp)
        )
    }
}

@Composable
private fun BackgroundImage() {
    Image(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
private fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    MySootheTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(id = R.string.log_in_email_address_label),
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
    MySootheTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(id = R.string.log_in_password_label),
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
private fun LogInScreenPreview() {
    MySootheTemplate {
        LoginScreen()
    }
}