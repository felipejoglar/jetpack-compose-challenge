package com.fjoglar.composechallenge.wetrade.data.model

data class Stock(
    val price: String,
    val percentDelta: String,
    val name: String,
    val company: String,
    val graph: Int,
)