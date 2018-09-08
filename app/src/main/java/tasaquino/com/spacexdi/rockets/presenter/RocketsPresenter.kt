package tasaquino.com.spacexdi.rockets.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import tasaquino.com.spacexdi.rockets.Rockets
import tasaquino.com.spacexdi.rockets.presenter.model.mapToViewModel

class RocketsPresenter(val source: Rockets.Source) : Rockets.Presenter {
    lateinit var view: Rockets.View

    override fun loadRockets() {
        view.showLoading()
        source.fetchRockets()
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.mapToViewModel() }
                .subscribe(view::showRockets, this::onError)
    }

    fun onError(t: Throwable) {
        view.showRockets(emptyList())
    }

    override fun bind(view: Rockets.View) {
        this.view = view
    }
}