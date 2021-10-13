package com.fjoglar.composechallenge.bloom.ui.screens

import android.content.res.Configuration
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
import androidx.compose.material.Surface
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.ui.components.BloomButton
import com.fjoglar.composechallenge.bloom.ui.components.BloomTextField
import com.fjoglar.composechallenge.bloom.ui.components.UrlClickableText
import com.fjoglar.composechallenge.bloom.ui.components.VerticalSpacer
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun LoginScreen() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    val focusRequester = FocusRequester()
    val onLoginClick: () -> Unit = { }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.log_in_title),
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .paddingFromBaseline(top = 184.dp, bottom = 16.dp)
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
            UrlClickableText(
                text = stringResource(R.string.log_in_legal_terms),
                urls = mapOf(
                    stringResource(R.string.log_in_terms_of_use) to "http://google.com",
                    stringResource(R.string.log_in_privacy_policy) to "http://github.com",
                ),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp, bottom = 16.dp)
                    .padding(horizontal = 16.dp)
            )
            BloomButton(
                text = stringResource(id = R.string.log_in),
                onClick = onLoginClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
private fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardAction: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BloomTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(R.string.log_in_email_address_label),
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
    BloomTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(R.string.log_in_password_label),
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
private fun LoginScreenPreview() {
    BloomTheme {
        LoginScreen()
    }
}