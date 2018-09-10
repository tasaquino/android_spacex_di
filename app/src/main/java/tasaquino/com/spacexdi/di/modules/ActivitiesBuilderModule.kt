package tasaquino.com.spacexdi.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tasaquino.com.spacexdi.RocketsActivity
import tasaquino.com.spacexdi.di.PerScreenSccope


@Module
abstract class ActivitiesBuilderModule {
    @PerScreenSccope
    @ContributesAndroidInjector(modules = [RocketsPresenterModule::class])
    abstract fun rocketsActivity(): RocketsActivity
}