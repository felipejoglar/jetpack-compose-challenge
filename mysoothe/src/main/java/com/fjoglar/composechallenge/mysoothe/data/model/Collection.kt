package com.fjoglar.composechallenge.mysoothe.data.model

import java.util.UUID

data class MySootheCollection(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val imageURL: String,
)
