package com.fjoglar.composechallenge.bloom.ui.screens.home.model

import com.fjoglar.composechallenge.bloom.data.model.Plant

data class HomeGardenItem(
    val plant: Plant,
    val isSelected: Boolean = false,
)

fun Plant.toHomeGardenItem() = HomeGardenItem(this)
