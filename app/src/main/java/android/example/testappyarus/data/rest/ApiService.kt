package android.example.testappyarus.data.rest

import android.example.testappyarus.domain.characters.Character
import android.example.testappyarus.domain.characters.CharacterApiResponse
import android.example.testappyarus.domain.characters.CharacterResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
//    @GET("character")
//    suspend fun getCharacters(): Response<RickMortyApiResponse?>

//    @GET("character")
//    suspend fun getCharacters(): Response<IResponse<List<Character>>>

    @GET("character")
    suspend fun getCharacters(): Response<CharacterApiResponse>?

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<Result?>

//    @GET("character/{id}")
//    suspend fun getCharacterDetails(@Path("id") id: Int): Response<CharacterResult?>

    @GET("location")
    suspend fun getLocations(): Response<RickMortyApiResponse?>

    @GET("location/{id}")
    suspend fun getLocationDetails(@Path("id") id: Int): Response<Result?>

//    @GET("episode")
//    suspend fun getEpisodes(): Response<RickMortyApiResponse?>
//
//    @GET("episode/{id}")
//    suspend fun getEpisodeDetails(@Path("id") id: Int): Response<Result?>
}