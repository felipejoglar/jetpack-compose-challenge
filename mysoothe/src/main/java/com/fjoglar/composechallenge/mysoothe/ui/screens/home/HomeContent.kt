package com.fjoglar.composechallenge.mysoothe.ui.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjoglar.composechallenge.mysoothe.R
import com.fjoglar.composechallenge.mysoothe.data.Repository
import com.fjoglar.composechallenge.mysoothe.ui.components.MySootheTemplate
import com.fjoglar.composechallenge.mysoothe.ui.components.VerticalSpacer
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.components.AlignCollections
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.components.FavoriteCollections
import com.fjoglar.composechallenge.mysoothe.ui.screens.home.components.SearchTextField

@Composable
fun HomeContent() {
    var searchQuery by rememberSaveable { mutableStateOf("") }

    val favoriteCollections by remember { mutableStateOf(Repository.favoriteCollections) }
    val bodyCollections by remember { mutableStateOf(Repository.alignYourBodyCollections) }
    val mindCollections by remember { mutableStateOf(Repository.alignYourMindCollections) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 16.dp),
    ) {
        VerticalSpacer(height = 56.dp)
        SearchTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        )
        FavoriteCollections(
            collections = favoriteCollections,
            modifier = Modifier
                .fillMaxWidth(),
        )
        AlignCollections(
            title = stringResource(id = R.string.home_align_body_collections_title),
            collections = bodyCollections
        )
        AlignCollections(
            title = stringResource(id = R.string.home_align_mind_collections_title),
            collections = mindCollections
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
private fun HomeContentPreview() {
    MySootheTemplate {
        HomeContent()
    }
}