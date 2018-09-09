package tasaquino.com.spacexdi

import android.app.Application
import tasaquino.com.spacexdi.di.components.DaggerAppComponent

class SpacexApplication : Application() {
    val appComponent by lazy { DaggerAppComponent.create() }
}