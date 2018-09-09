package tasaquino.com.spacexdi.di.components

import dagger.Component
import tasaquino.com.spacexdi.di.modules.NetworkingModule
import tasaquino.com.spacexdi.networking.SpacexAPI
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkingModule::class])
interface AppComponent {
    fun api(): SpacexAPI

    fun screenSubComponent(): ScreenSubComponent
}