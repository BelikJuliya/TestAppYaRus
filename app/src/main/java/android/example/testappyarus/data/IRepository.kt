package android.example.testappyarus.data

import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.characters.CharacterResult
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.locations.Location

interface IRepository {

    suspend fun getCharacters(): IResponse<List<Character>>?

    suspend fun getCharacterDetails(id: Int): CharacterResult?

    suspend fun getLocations(): IResponse<List<Location>>?

    suspend fun getLocationDetails(id: Int): Result? // to implement

    suspend fun getEpisodes(): IResponse<List<Episode>>?

//    suspend fun getEpisodeDetails(id: Int): Result?
}