package android.example.testappyarus.domain.characters

import android.example.testappyarus.domain.common.Origin
import android.location.Location

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
    val episode: String,
    val url: String,
    val created: String
){

}
