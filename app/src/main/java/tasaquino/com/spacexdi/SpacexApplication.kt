package tasaquino.com.spacexdi

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import tasaquino.com.spacexdi.di.modules.appModule

class SpacexApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(appModule)
    }
}