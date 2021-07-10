package android.example.testappyarus.data.rest

import android.example.testappyarus.domain.Character
import android.example.testappyarus.domain.Episode
import android.example.testappyarus.domain.Location
import android.example.testappyarus.domain.Origin
import com.google.gson.annotations.SerializedName

data class Result(
    val created: String,
    val episode: String,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    val dimension: String,
    val residents: List<String>,
    val airDate: String,
    @SerializedName("episode")
    val episodesList: List<Episode>,
    val characters: List<Character>
)


