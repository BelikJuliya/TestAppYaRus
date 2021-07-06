package android.example.testappyarus.data.rest

import android.example.testappyarus.domain.Location
import android.example.testappyarus.domain.Origin

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)


