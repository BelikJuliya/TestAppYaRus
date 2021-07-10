package android.example.testappyarus.data

import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.locations.Location

interface IRepository {

    suspend fun getCharacterApiCall(): List<Character>

    suspend fun getCharacterDetails(id: Int): Result?

    suspend fun getLocations(): List<Location>

    suspend fun getLocationDetails(id: Int): Result?

//    suspend fun getEpisodes(): List<Episode>
//
//    suspend fun getEpisodeDetails(id: Int): Result?
}