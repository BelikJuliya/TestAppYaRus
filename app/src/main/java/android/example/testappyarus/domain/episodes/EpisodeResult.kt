package android.example.testappyarus.domain.episodes

import android.example.testappyarus.domain.characters.Character

data class EpisodeResult(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<Character>,
    val url: String,
    val created: String
)
