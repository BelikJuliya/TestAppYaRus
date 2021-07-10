package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.characters.CharacterResult
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.locations.Location
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getCharacters(): IResponse<List<Character>>? {
        return apiService.getCharacters()?.body()
    }

    override suspend fun getCharacterDetails(id: Int): CharacterResult? {
        return apiService.getCharacterDetails(id).body()
    }

    override suspend fun getLocations(): IResponse<List<Location>>? {
        return apiService.getLocations()?.body()
    }

    override suspend fun getLocationDetails(id: Int): Result? {
        return apiService.getLocationDetails(id).body()
    }

    override suspend fun getEpisodes(): IResponse<List<Episode>>? {
        return apiService.getEpisodes()?.body()
    }

//    override suspend fun getEpisodes(): List<Episode> {
//        val episodes = ArrayList<Episode>()
////        val response = apiService.getEpisodes().body()
////        response?.results?.forEach { result ->
////            episodes.add(
////                Episode(
////                    result.id,
////                    result.name,
////                    result.airDate,
////                    result.episode // there is the same field which is List
////                )
////            )
////        }
//        return episodes
//    }
//
//    override suspend fun getEpisodeDetails(id: Int): Result? {
//        return apiService.getEpisodeDetails(id).body()
//    }
}

