package android.example.testappyarus.data

import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.Character
import android.example.testappyarus.domain.Episode
import android.example.testappyarus.domain.Location

interface IRepository {

    suspend fun getCharacterApiCall(): List<Character>

    suspend fun getCharacterDetails(id: Int): Result?

    suspend fun getLocations(): List<Location>

    suspend fun getLocationDetails(id: Int): Result?

    suspend fun getEpisodes(): List<Episode>

    suspend fun getEpisodeDetails(id: Int): Result?
}