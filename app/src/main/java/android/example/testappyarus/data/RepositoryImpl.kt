package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.domain.Character
import java.util.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getCharacterApiCall(): List<Character> {
        val listCharacters = ArrayList<Character>()
        val response = apiService.getCharacters().body()
        response?.results?.forEach { result ->
            listCharacters.add(
                Character(
                    result.name,
                    result.species,
                    result.image,
                    result.id
                )
            )
        }
        println("List characters loaded")
        return listCharacters
    }
}

