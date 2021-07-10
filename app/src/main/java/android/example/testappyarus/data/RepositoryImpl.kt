package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.episodes.Episode
import android.example.testappyarus.domain.locations.Location
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getCharacters(): IResponse<List<Character>>? {
        val response = apiService.getCharacters()?.body()
        println("response received " + response?.results?.size)
        return response

    }
//    override suspend fun getCharacterApiCall(): List<Character> {
//        val listCharacters = ArrayList<Character>()
//        val response = apiService.getCharacters().body()
//        response?.results?.forEach { result ->
//            listCharacters.add(
//                Character(
//                    result.name,
//                    result.species,
//                    result.image,
//                    result.id
//                )
//            )
//        }
//        println("List characters loaded")
//        return listCharacters
//    }

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

