package android.example.testappyarus.domain.characters

import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.InfoX

data class CharacterResponse(
    val info: InfoX,
    val results: List<CharacterResult>
) : IResponse<List<Character>> {
    override fun toDomainObject(): List<Character> {
        return results.map { characterResult ->
            Character(
                characterResult.id,
                characterResult.name,
                characterResult.species,
                characterResult.status,
                characterResult.gender,
                characterResult.image,
                characterResult.location
            )
        }
    }
    override fun getPage() = info.pages
}
