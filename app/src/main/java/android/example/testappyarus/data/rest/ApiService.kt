package android.example.testappyarus.data.rest

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("character")
    suspend fun getCharacters(): Response<RickMortyApiResponse?>

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<Result?>

    @GET("location")
    suspend fun getLocations(): Response<RickMortyApiResponse?>

    @GET("location/{id}")
    suspend fun getLocationDetails(@Path("id") id: Int): Response<Result?>

//    @GET("episode")
//    suspend fun getEpisodes(): List<EpisodeResponce>
}