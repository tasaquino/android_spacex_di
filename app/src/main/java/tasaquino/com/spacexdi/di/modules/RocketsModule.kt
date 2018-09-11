package tasaquino.com.spacexdi.di.modules

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.infrastructure.RocketsInfrastructure
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter

val rocketsSourceModule = Kodein.Module("rocketsSourceModule") {

    bind<Rockets.Source>() with singleton{
        RocketsInfrastructure(api = instance())
    }
}

val rocketsPresenterModule = Kodein.Module("rocketsPresenterModule") {

    bind<Rockets.Presenter>() with singleton {
        RocketsPresenter(source = instance())
    }
}