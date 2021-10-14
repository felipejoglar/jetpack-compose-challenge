package com.fjoglar.composechallenge.bloom.data

import com.fjoglar.composechallenge.bloom.R
import com.fjoglar.composechallenge.bloom.data.model.Plant
import com.fjoglar.composechallenge.bloom.data.model.Theme

object Repository {

    private const val DESCRIPTION = "This is a description"

    fun getPlants() = listOf(
        Plant(name = "Monstera", description = DESCRIPTION, image = R.drawable.monstera),
        Plant(name = "Aglaomena", description = DESCRIPTION, image = R.drawable.aglaonema),
        Plant(name = "Peace lily", description = DESCRIPTION, image = R.drawable.peace_lily),
        Plant(name = "Fiddle leaf tree", description = DESCRIPTION, image = R.drawable.fiddle_leaf),
        Plant(name = "Snake plant", description = DESCRIPTION, image = R.drawable.snake_plant),
        Plant(name = "Pothos", description = DESCRIPTION, image = R.drawable.pothos),
    )

    fun getThemes() = listOf(
        Theme(name = "Desert chic", image = R.drawable.desert_chic),
        Theme(name = "Tiny terrariums", image = R.drawable.tiny_terrariums),
        Theme(name = "Jungle vibes", image = R.drawable.jungle_vibes),
        Theme(name = "Easy care", image = R.drawable.easy_care),
        Theme(name = "Statements", image = R.drawable.statements),
    )
}

