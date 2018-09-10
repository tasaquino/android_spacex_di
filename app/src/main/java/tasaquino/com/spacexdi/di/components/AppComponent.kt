package tasaquino.com.spacexdi.di.components

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import tasaquino.com.spacexdi.SpacexApplication
import tasaquino.com.spacexdi.di.modules.ActivitiesBuilderModule
import tasaquino.com.spacexdi.di.modules.AppModule
import tasaquino.com.spacexdi.di.modules.NetworkingModule
import tasaquino.com.spacexdi.networking.SpacexAPI
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkingModule::class,
    ActivitiesBuilderModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent {
    fun inject(app: SpacexApplication)
    fun api(): SpacexAPI
}