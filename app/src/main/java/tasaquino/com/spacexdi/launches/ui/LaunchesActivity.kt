package tasaquino.com.spacexdi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tasaquino.com.spacexdi.launches.Launches

class LaunchesActivity : AppCompatActivity(), Launches.View {
    override fun showLaunches() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var presenter: Launches.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launches)
    }
}