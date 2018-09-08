package tasaquino.com.spacexdi.rockets.infrastructure.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import io.reactivex.Observable


data class RocketPayload(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String)