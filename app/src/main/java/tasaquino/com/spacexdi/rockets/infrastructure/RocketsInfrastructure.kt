package tasaquino.com.spacexdi.rockets.infrastructure

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.kodein.di.Kodein
import org.kodein.di.generic.instance
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.networking.SpacexAPI
import tasaquino.com.spacexdi.rockets.infrastructure.model.Rocket

class RocketsInfrastructure(private val kodein: Kodein) : Rockets.Source {

    override fun fetchRockets(): Observable<List<Rocket>> {
        val api: SpacexAPI by kodein.instance()

        return api.getRockets()
                .subscribeOn(Schedulers.io())
                .map { RocketMapper.map(it) }
    }
}


