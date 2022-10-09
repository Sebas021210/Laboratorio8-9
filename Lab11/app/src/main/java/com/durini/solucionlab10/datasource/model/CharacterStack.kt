package com.durini.solucionlab10.datasource.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterStack(
    @PrimaryKey
    val id: String,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: String,
    val episode: Int
)
