package android.example.testappyarus.domain.characters

import android.example.testappyarus.domain.common.Origin
import android.example.testappyarus.domain.locations.Location

data class CharacterResult(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)
