package tasaquino.com.spacexdi

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import tasaquino.com.spacexdi.di.components.DaggerAppComponent
import javax.inject.Inject

class SpacexApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .create()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}