package com.fjoglar.composechallenge.bloom.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun BloomTextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colors.secondary),
        modifier = modifier
            .height(48.dp),
    ) {
        Text(text)
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
private fun BloomButtonPreview() {
    BloomTheme {
        BloomTextButton(
            text = "Bloom Button",
            onClick = {}
        )
    }
}