package android.example.testappyarus.data

import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.Character

interface IRepository {
    suspend fun getCharacterApiCall(): List<Character>

    suspend fun getCharacterDetails(id: Int): Result?

}