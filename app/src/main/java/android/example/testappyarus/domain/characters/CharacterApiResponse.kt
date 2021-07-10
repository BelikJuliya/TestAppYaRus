package android.example.testappyarus.domain.characters

import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.InfoX

data class CharacterApiResponse(
    val info: InfoX,
    val results: List<CharacterResult>
) : IResponse<List<Character>> {
    override fun toDomainObject(): List<Character> {
        return results.map { characterResult ->
            Character(
                characterResult.name,
                characterResult.species,
                characterResult.image,
                characterResult.id
            )
        }
    }
}
