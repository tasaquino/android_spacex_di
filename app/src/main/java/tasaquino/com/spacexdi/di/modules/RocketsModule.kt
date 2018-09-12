package tasaquino.com.spacexdi.di.modules

import org.koin.dsl.module.module
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.infrastructure.RocketsInfrastructure
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter

val rocketSourceModule = module {
    single<Rockets.Source> { RocketsInfrastructure(get()) }
}

val rocketPresenterModule = module {
    factory<Rockets.Presenter> { RocketsPresenter(get()) }
}