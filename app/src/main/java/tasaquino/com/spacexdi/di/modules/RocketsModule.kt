package tasaquino.com.spacexdi.di.modules

import dagger.Module
import dagger.Provides
import tasaquino.com.spacexdi.di.PerScreenSccope
import tasaquino.com.spacexdi.networking.SpacexAPI
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.infrastructure.RocketsInfrastructure
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter

@Module(includes = [NetworkingModule::class])
class RocketsSourceModule {

    @Provides
    @PerScreenSccope
    fun provideSource(api: SpacexAPI): Rockets.Source = RocketsInfrastructure(api)
}

@Module(includes = [RocketsSourceModule::class])
class RocketsPresenterModule() {

    @Provides
    @PerScreenSccope
    fun providePresenter(source: Rockets.Source): Rockets.Presenter {
        return RocketsPresenter(source)
    }
}