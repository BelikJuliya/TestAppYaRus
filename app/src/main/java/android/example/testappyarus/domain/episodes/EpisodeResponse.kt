package android.example.testappyarus.domain.episodes

import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.InfoX

data class EpisodeResponse(
    val info: InfoX,
    val results: List<EpisodeResult>
) : IResponse<List<Episode>> {
    override fun toDomainObject(): List<Episode> {
        return results.map { episodeResult ->
            Episode(
                episodeResult.id,
                episodeResult.name,
                episodeResult.air_date,
                episodeResult.episode
            )
        }
    }

    override fun getPage() = info.pages
}
