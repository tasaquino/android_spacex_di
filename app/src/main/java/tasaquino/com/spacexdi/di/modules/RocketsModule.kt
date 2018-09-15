package tasaquino.com.spacexdi.di.modules

import org.kodein.di.Kodein
import org.kodein.di.android.AndroidComponentsWeakScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.infrastructure.RocketsInfrastructure
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter

val rocketsSourceModule = Kodein.Module("rocketsSourceModule") {

    bind<Rockets.Source>() with scoped(AndroidComponentsWeakScope).singleton {
        RocketsInfrastructure(kodein = kodein)
    }
}

val rocketsPresenterModule = Kodein.Module("rocketsPresenterModule") {

    bind<Rockets.Presenter>() with scoped(AndroidComponentsWeakScope).singleton {
        RocketsPresenter(source = instance())
    }
}