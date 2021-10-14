package com.fjoglar.composechallenge.bloom.data.model

import androidx.annotation.DrawableRes

data class Plant(
    val name: String,
    val description: String,
    @DrawableRes val image: Int,
)
