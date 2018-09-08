package tasaquino.com.spacexdi.rockets.infrastructure

import tasaquino.com.spacexdi.rockets.infrastructure.model.Rocket
import tasaquino.com.spacexdi.rockets.infrastructure.model.RocketPayload

object RocketMapper {
    fun map(payload: List<RocketPayload>): List<Rocket> {
        return payload
                .filter { it.name.isNotEmpty() }
                .map { Rocket(it.id, it.name) }
    }
}