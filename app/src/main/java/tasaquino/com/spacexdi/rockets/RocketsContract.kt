package tasaquino.com.spacexdi.rockets

import io.reactivex.Observable
import tasaquino.com.spacexdi.rockets.infrastructure.model.Rocket
import tasaquino.com.spacexdi.rockets.presenter.model.RocketViewModel

interface Rockets {
    interface Source {
        fun fetchRockets(): Observable<List<Rocket>>
    }

    interface Presenter {
        fun loadRockets()
        fun bind(view: View)
    }

    interface View {
        fun showRockets(rockets: List<RocketViewModel>)
        fun showLoading()
        fun hideLoading()
    }
}