package tasaquino.com.spacexdi.di.components

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import tasaquino.com.spacexdi.SpacexApplication
import tasaquino.com.spacexdi.di.modules.ActivitiesBuilderModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivitiesBuilderModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent {
    fun inject(app: SpacexApplication)
}