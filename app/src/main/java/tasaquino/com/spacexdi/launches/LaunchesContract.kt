package tasaquino.com.spacexdi.launches

import tasaquino.com.spacexdi.launches.presenter.model.LaunchViewModel

interface Launches {
    interface Source {
        fun fetchLaunches(): List<LaunchViewModel>
    }

    interface Presenter {
        fun loadLaunches()
    }

    interface View{
        fun showLaunches()
        fun showLoading()
        fun hideLoading()
    }
}