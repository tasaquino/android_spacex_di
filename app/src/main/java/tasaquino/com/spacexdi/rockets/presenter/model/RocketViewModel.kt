package tasaquino.com.spacexdi.rockets.presenter.model

import tasaquino.com.spacexdi.rockets.infrastructure.model.Rocket

data class RocketViewModel(val name: String)

fun List<Rocket>.mapToViewModel() = this.map { RocketViewModel(it.name) }