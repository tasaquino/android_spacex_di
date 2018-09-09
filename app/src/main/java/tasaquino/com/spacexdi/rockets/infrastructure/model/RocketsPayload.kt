package tasaquino.com.spacexdi.rockets.infrastructure.model

import com.google.gson.annotations.SerializedName


data class RocketPayload(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String)