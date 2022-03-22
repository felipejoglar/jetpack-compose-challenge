package com.fjoglar.composechallenge.mysoothe.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.fjoglar.composechallenge.mysoothe.R
import com.fjoglar.composechallenge.mysoothe.data.Repository
import com.fjoglar.composechallenge.mysoothe.data.model.MySootheCollection
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate

@Composable
fun FavoriteCollections(
    collections: List<MySootheCollection>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.home_favorite_collections_title).uppercase(),
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier,
        ) {
            items(collections.chunked(2)) {
                FavoriteCollectionsItem(collections = it)
            }
        }
    }
}

@Composable
private fun FavoriteCollectionsItem(
    collections: List<MySootheCollection>,
    modifier: Modifier = Modifier
) {
    require(collections.count() == 2)
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(vertical = 8.dp)
    ) {
        CollectionCard(collection = collections[0])
        CollectionCard(collection = collections[1])
    }
}

@Composable
private fun CollectionCard(
    collection: MySootheCollection,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .size(width = 192.dp, height = 56.dp)
            .background(MaterialTheme.colors.surface),
    ) {
        Image(
            painter = rememberImagePainter(
                data = collection.imageURL,
                builder = {
                    crossfade(true)
                },
            ),
            contentDescription = collection.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f),
        )
        Text(
            text = collection.name,
            style = MaterialTheme.typography.h3,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.padding(horizontal = 16.dp),
        )
    }
}

@Preview(
    name = "Day Mode",
    widthDp = 360,
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Preview(
    name = "Night Mode",
    widthDp = 360,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
private fun FavoriteCollectionsPreview() {
    MySootheTemplate {
        FavoriteCollections(
            collections = Repository.favoriteCollections
        )
    }
}