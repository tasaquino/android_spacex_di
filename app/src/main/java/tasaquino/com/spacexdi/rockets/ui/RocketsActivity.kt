package tasaquino.com.spacexdi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.kodein.di.Copy
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.instance
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.presenter.model.RocketViewModel

class RocketsActivity : AppCompatActivity(), KodeinAware, Rockets.View {
    private val _parentKodein by closestKodein()
    override val kodein: Kodein by retainedKodein {
        extend(_parentKodein, copy = Copy.All)
        import(appDiModule)
    }

    override fun showRockets(rockets: List<RocketViewModel>) {
        Log.d("Rockets", "Awsome rockets: $rockets")
    }

    private val presenter by instance<Rockets.Presenter>()
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