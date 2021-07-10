package android.example.testappyarus.data.rest

import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.locations.Location
import android.example.testappyarus.domain.common.Origin
import com.google.gson.annotations.SerializedName
data class Result(
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
//data class Result(
//    val created: String,
//    val episode: List<Episode>,
//    val gender: String,
//    val id: Int,
//    val image: String,
//    val location: Location,
//    val name: String,
//    val origin: Origin,
//    val species: String,
//    val status: String,
//    val type: String,
//    val url: String,
//    val dimension: String,
//    val residents: List<String>,
//   // val airDate: String,
//   // val episode: List<Episode>,
////    val characters: List<Character>
//){
//
//}


