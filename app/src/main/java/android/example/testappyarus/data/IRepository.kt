package android.example.testappyarus.data

import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.characters.CharacterResult
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.episodes.EpisodeResult
import android.example.testappyarus.domain.locations.Location
import android.example.testappyarus.domain.locations.LocationResult

interface IRepository {

    suspend fun getCharacters(page: Int): IResponse<List<Character>>?

    suspend fun getCharacterDetails(id: Int): CharacterResult?

    suspend fun getLocations(page: Int): IResponse<List<Location>>?

    suspend fun getLocationDetails(id: Int): LocationResult?

    suspend fun getEpisodes(page: Int): IResponse<List<Episode>>?

    suspend fun getEpisodeDetails(id: Int): EpisodeResult?
}