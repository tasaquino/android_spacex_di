package tasaquino.com.spacexdi.di.components

import dagger.Subcomponent
import tasaquino.com.spacexdi.RocketsActivity
import tasaquino.com.spacexdi.di.PerScreenSccope
import tasaquino.com.spacexdi.di.modules.RocketsPresenterModule

@PerScreenSccope
@Subcomponent(modules = [RocketsPresenterModule::class])
interface ScreenSubComponent {
    fun inject(activity: RocketsActivity)
}