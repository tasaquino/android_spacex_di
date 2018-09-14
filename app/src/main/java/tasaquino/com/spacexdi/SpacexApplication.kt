package tasaquino.com.spacexdi

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import tasaquino.com.spacexdi.di.modules.networkingModule
import tasaquino.com.spacexdi.di.modules.rocketsPresenterModule
import tasaquino.com.spacexdi.di.modules.rocketsSourceModule

class SpacexApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(networkingModule)
        import(rocketsSourceModule)
        import(rocketsPresenterModule)
    }
}


