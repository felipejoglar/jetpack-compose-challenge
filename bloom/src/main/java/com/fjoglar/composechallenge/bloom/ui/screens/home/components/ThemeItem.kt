package com.fjoglar.composechallenge.bloom.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.data.Repository
import com.fjoglar.composechallenge.bloom.data.model.Theme
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun ThemeItem(
    theme: Theme,
    modifier: Modifier = Modifier,
) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = MaterialTheme.colors.surface,
        modifier = modifier
            .size(136.dp),
    ) {
        Column {
            Image(
                painter = rememberImagePainter(
                    data = theme.imageUrl,
                    builder = {
                        crossfade(true)
                    },
                ),
                contentDescription = stringResource(
                    id = R.string.home_themes_list_content_description,
                    theme.name,
                ),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp),
            )
            Text(
                text = theme.name,
                style = MaterialTheme.typography.h2,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 16.dp),
            )
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
private fun ThemeItemPreview() {
    BloomTheme {
        ThemeItem(
            theme = Repository.getThemes().first(),
        )
    }
}