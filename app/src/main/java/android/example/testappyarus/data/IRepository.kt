package android.example.testappyarus.data

import android.example.testappyarus.domain.Character

interface IRepository {
    suspend fun getCharacterApiCall(): List<Character>

    //fun getCall()
}