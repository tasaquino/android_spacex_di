package tasaquino.com.spacexdi

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import tasaquino.com.spacexdi.di.modules.networkingModule
import tasaquino.com.spacexdi.di.modules.rocketsPresenterModule
import tasaquino.com.spacexdi.di.modules.rocketsSourceModule
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter

class SpacexApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein {
        import(appDiModule)
    }
}


val appDiModule = Kodein.Module("appDiModule") {
    import(networkingModule)
    import(rocketsSourceModule)
    import(rocketsPresenterModule)
}