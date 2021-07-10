package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.Character
import android.example.testappyarus.domain.Episode
import android.example.testappyarus.domain.Location
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getCharacterApiCall(): List<Character> {
        val listCharacters = ArrayList<Character>()
        val response = apiService.getCharacters().body()
        response?.results?.forEach { result ->
            listCharacters.add(
                Character(
                    result.name,
                    result.species,
                    result.image,
                    result.id
                )
            )
        }
        println("List characters loaded")
        return listCharacters
    }

    override suspend fun getCharacterDetails(id: Int): Result? {
        return apiService.getCharacterDetails(id).body()
    }

    override suspend fun getLocations(): List<Location> {
        val locationsList = ArrayList<Location>()
        val response = apiService.getLocations().body()
        response?.results?.forEach { result ->
            locationsList.add(
                Location(
                    result.id,
                    result.name,
                    result.type,
                    result.created
                )
            )
        }
        return locationsList
    }

    override suspend fun getLocationDetails(id: Int): Result? {
        return apiService.getLocationDetails(id).body()
    }

    override suspend fun getEpisodes(): List<Episode> {
        val episodes = ArrayList<Episode>()
        val response = apiService.getEpisodes().body()
        response?.results?.forEach { result ->
            episodes.add(
                Episode(
                    result.id,
                    result.name,
                    result.airDate,
                    result.episode // there is the same field which is List
                )
            )
        }
        return episodes
    }

    override suspend fun getEpisodeDetails(id: Int): Result? {
        return apiService.getEpisodeDetails(id).body()
    }
}

