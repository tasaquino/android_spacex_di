package tasaquino.com.spacexdi.rockets.infrastructure

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.networking.SpacexAPI
import tasaquino.com.spacexdi.rockets.infrastructure.model.Rocket

class RocketsInfrastructure(private val api: SpacexAPI) : Rockets.Source {

    override fun fetchRockets(): Observable<List<Rocket>> {

        return api.getRockets()
                .subscribeOn(Schedulers.io())
                .map { RocketMapper.map(it) }
    }
}