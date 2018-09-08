package tasaquino.com.spacexdi.networking

import io.reactivex.Observable
import retrofit2.http.GET
import tasaquino.com.spacexdi.rockets.infrastructure.model.RocketPayload


interface SpacexAPI {

    @GET("v2/rockets")
    fun getRockets(): Observable<List<RocketPayload>>
}