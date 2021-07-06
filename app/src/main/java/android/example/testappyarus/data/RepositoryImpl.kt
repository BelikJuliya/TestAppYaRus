package android.example.testappyarus.data

import android.example.testappyarus.data.rest.ApiService
import android.example.testappyarus.domain.Character
import java.util.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : IRepository {
    override suspend fun getCharacterApiCall(): List<Character> {
        //val characterResponse = apiService.getCharacters()
        val listCharacters = ArrayList<Character>()
        val response = apiService.getCharacters().body()
        response?.results?.forEach { result ->
            listCharacters.add(
                Character(
                    result.name,
                    result.species,
                    result.image
                )
            )
        }
        return listCharacters
    }

//    override fun getCall() {
//        val call = apiService.getCharactersCall()
//        call.enqueue(object : Callback<CharacterResponse> {
//            override fun onFailure(call: Call<CharacterResponse>?, t: Throwable?) {
//                Log.v("retrofit", "call failed")
//            }
//
//            override fun onResponse(call: Call<CharacterResponse>?, response: Response<CharacterResponse>?) {
//                Log.v("retrofit", "call succeeded")
//
//            }
//        })
//    }
}

