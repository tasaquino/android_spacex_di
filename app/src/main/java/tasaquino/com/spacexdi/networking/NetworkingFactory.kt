package tasaquino.com.spacexdi.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkingFactory {

    val api: SpacexAPI by lazy { provideApi() }

    private fun provideApi(): SpacexAPI {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(SpacexAPI::class.java)
    }
}