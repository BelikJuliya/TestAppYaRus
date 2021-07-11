package android.example.testappyarus.di

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.presentation.characterFlow.list.CharacterListAdapter
import android.example.testappyarus.presentation.episodesFlow.list.EpisodesListAdapter
import android.example.testappyarus.presentation.locationFlow.list.LocationsListAdapter
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideEpisodesAdapter(): EpisodesListAdapter {
        return EpisodesListAdapter()
    }

    @Provides
    fun provideCharactersAdapter(): CharacterListAdapter {
        return CharacterListAdapter()
    }

    @Provides
    fun provideLocationsAdapter(): LocationsListAdapter {
        return LocationsListAdapter()
    }
}