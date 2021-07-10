package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.characters.CharacterResult
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.episodes.EpisodeResult
import android.example.testappyarus.domain.locations.Location
import android.example.testappyarus.domain.locations.LocationResult
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getCharacters(page: Int): IResponse<List<Character>>? {
        val tmp = apiService.getCharacters(page)
//        val tmp = apiService.getCharacters()
        println("response: " + tmp?.code())
        println(tmp?.body())
//        return apiService.getCharacters(page)?.body()
        return tmp.body()
    }

    override suspend fun getCharacterDetails(id: Int): CharacterResult? {
        return apiService.getCharacterDetails(id).body()
    }

    override suspend fun getLocations(page: Int): IResponse<List<Location>>? {
        return apiService.getLocations(page)?.body()
    }

    override suspend fun getLocationDetails(id: Int): LocationResult? {
        return apiService.getLocationDetails(id).body()
    }

    override suspend fun getEpisodes(): IResponse<List<Episode>>? {
        return apiService.getEpisodes()?.body()
    }

    override suspend fun getEpisodeDetails(id: Int): EpisodeResult? {
        return apiService.getEpisodeDetails(id).body()
    }
}

