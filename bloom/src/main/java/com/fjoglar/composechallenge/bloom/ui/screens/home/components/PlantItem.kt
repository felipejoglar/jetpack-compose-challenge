package com.fjoglar.composechallenge.bloom.ui.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.fjoglar.composechallenge.bloom.data.Repository
import com.fjoglar.composechallenge.bloom.data.model.Plant
import com.fjoglar.composechallenge.bloom.ui.components.VerticalSpacer
import com.fjoglar.composechallenge.bloom.ui.theme.BloomTheme

@Composable
fun PlantItem(
    plant: Plant,
    checked: Boolean,
    onCheckedChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(horizontal = 16.dp),
    ) {
        Image(
            painter = rememberImagePainter(
                data = plant.imageUrl,
                builder = {
                    crossfade(true)
                },
            ),
            contentDescription = plant.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .clip(MaterialTheme.shapes.small)
        )
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            Divider(
                thickness = 2.dp,
                startIndent = 8.dp,
                color = MaterialTheme.colors.surface,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )

            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp),
                ) {
                    Text(
                        text = plant.name,
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier
                            .paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = plant.description,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .paddingFromBaseline(bottom = 24.dp)
                    )
                }

                Checkbox(
                    checked = checked,
                    onCheckedChange = onCheckedChanged,
                    colors = CheckboxDefaults.colors(
                        checkmarkColor = MaterialTheme.colors.background
                    ),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
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
private fun PlantItemPreview() {
    BloomTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.padding(vertical = 8.dp)
            ) {

                PlantItem(Repository.getPlants().first(),
                    checked = true,
                    onCheckedChanged = {})
                VerticalSpacer(height = 8.dp)
                PlantItem(Repository.getPlants().last(),
                    checked = false,
                    onCheckedChanged = {})
            }
        }
    }
}