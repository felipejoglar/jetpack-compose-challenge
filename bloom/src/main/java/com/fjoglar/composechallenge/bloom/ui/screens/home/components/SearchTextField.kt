package com.fjoglar.composechallenge.bloom.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.ui.components.BloomTemplate
import com.fjoglar.composechallenge.bloom.ui.components.BloomTextField

@Composable
fun SearchTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    BloomTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = stringResource(R.string.home_search_label),
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        modifier = modifier
    )
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
private fun SearchTextFieldPreview() {
    BloomTemplate {
        SearchTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.padding(16.dp)
        )
    }
}