package android.example.testappyarus.data.rest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse?>

    @GET("character")
    fun getCharactersCall(): Call<CharacterResponse>

//    @GET("location")
//    suspend fun getLocations(): List<LocationResponce>
//
//    @GET("episode")
//    suspend fun getEpisodes(): List<EpisodeResponce>
}