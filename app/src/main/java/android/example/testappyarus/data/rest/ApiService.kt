package android.example.testappyarus.data.rest

import android.example.testappyarus.domain.characters.CharacterResponse
import android.example.testappyarus.domain.characters.CharacterResult
import android.example.testappyarus.domain.episodes.EpisodeResponse
import android.example.testappyarus.domain.episodes.EpisodeResult
import android.example.testappyarus.domain.locations.LocationResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): Response<CharacterResponse>?

    @GET("character/{id}")
    suspend fun getCharacterDetails(@Path("id") id: Int): Response<CharacterResult>
//
//    @GET("location")
//    suspend fun getLocations(): Response<RickMortyApiResponse?>

    @GET("location")
    suspend fun getLocations(): Response<LocationResponse>?

    @GET("location/{id}")
    suspend fun getLocationDetails(@Path("id") id: Int): Response<Result?>

    @GET("episode")
    suspend fun getEpisodes(): Response<EpisodeResponse>?

    @GET("episode/{id}")
    suspend fun getEpisodeDetails(@Path("id") id: Int): Response<EpisodeResult>
}