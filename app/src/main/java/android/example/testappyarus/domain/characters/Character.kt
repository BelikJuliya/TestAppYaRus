package android.example.testappyarus.domain.characters

import android.example.testappyarus.domain.locations.Location

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val imageUrl: String,
    val location: Location
)