package tasaquino.com.spacexdi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.infrastructure.RocketsInfrastructure
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter
import tasaquino.com.spacexdi.rockets.presenter.model.RocketViewModel

class RocketsActivity : AppCompatActivity(), Rockets.View {
    override fun showRockets(rockets: List<RocketViewModel>) {
        Log.d("Rockets", "Awsome rockets: $rockets")
    }

    lateinit var presenter: Rockets.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets)

        bindViewAndLoad()
    }

    private fun bindViewAndLoad() {
        presenter = RocketsPresenter(source = RocketsInfrastructure())
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