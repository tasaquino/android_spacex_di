package tasaquino.com.spacexdi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.infrastructure.RocketsInfrastructure
import tasaquino.com.spacexdi.rockets.presenter.RocketsPresenter
import tasaquino.com.spacexdi.rockets.presenter.model.RocketViewModel
import javax.inject.Inject

class RocketsActivity : AppCompatActivity(), Rockets.View {

    @Inject
    lateinit var presenter: Rockets.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rockets)

        bindViewAndLoad()
    }

    private fun bindViewAndLoad() {
        AndroidInjection.inject(this)
        presenter.bind(this)
        presenter.loadRockets()
    }

    override fun showRockets(rockets: List<RocketViewModel>) {
        Log.d("Rockets", "Awsome rockets: $rockets")
    }

    override fun showLoading() {
        Log.d("Rockets", "Loading...")
    }

    override fun hideLoading() {
        Log.d("Rockets", "Not Loading anymore :)")
    }
}