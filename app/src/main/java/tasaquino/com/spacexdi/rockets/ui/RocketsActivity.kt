package tasaquino.com.spacexdi.rockets.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject
import tasaquino.com.spacexdi.R
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.presenter.model.RocketViewModel

class RocketsActivity : AppCompatActivity(), Rockets.View {
    override fun showRockets(rockets: List<RocketViewModel>) {
        Log.d("Rockets", "Awsome rockets: $rockets")
    }

    val presenter : Rockets.Presenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets)

        bindViewAndLoad()
    }

    private fun bindViewAndLoad() {
        presenter.bind(this)
        presenter.loadRockets()
    }

    override fun showLoading() {
        Log.d("Rockets", "Loading...")
    }

    override fun hideLoading() {
        Log.d("Rockets", "Not Loading anymore :)")
    }
}