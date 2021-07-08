package android.example.testappyarus.data.rest

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse?>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<Result?>

    @GET("character/3")
    suspend fun getCharacterDetailsTest(): Response<Result>

//    @GET("location")
//    suspend fun getLocations(): List<LocationResponce>
//
//    @GET("episode")
//    suspend fun getEpisodes(): List<EpisodeResponce>
}