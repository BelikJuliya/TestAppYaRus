package android.example.testappyarus.domain.locations

import android.example.testappyarus.data.rest.IResponse
import android.example.testappyarus.data.rest.InfoX

data class LocationResponse(
    val info: InfoX,
    val results: List<LocationResult>
): IResponse<List<Location>> {
    override fun toDomainObject(): List<Location> {
        return results.map { locationResult ->
            Location(
                locationResult.id,
                locationResult.name,
                locationResult.type,
                locationResult.dimension
            )
        }
    }

    override fun getPage() = info.pages
}
