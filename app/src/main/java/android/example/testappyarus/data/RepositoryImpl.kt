package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.data.rest.Result
import android.example.testappyarus.domain.Character
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

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

    override suspend fun getCharacterDetails(id: Int): ArrayList<Result> {
        val listCharacterDetails = ArrayList<Result>()
        val response = apiService.getCharacterDetails(id).body()
        response?.results?.forEach { result ->
            listCharacterDetails.add(result)
        }
        return listCharacterDetails
    }
}

