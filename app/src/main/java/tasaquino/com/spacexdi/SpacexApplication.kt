package tasaquino.com.spacexdi

import android.app.Application
import org.koin.android.ext.android.startKoin
import tasaquino.com.spacexdi.di.modules.*

class SpacexApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                networkingModule,
                rocketSourceModule,
                rocketPresenterModule
        ))
    }
}