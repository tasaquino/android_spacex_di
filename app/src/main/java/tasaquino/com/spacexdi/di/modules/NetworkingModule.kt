package tasaquino.com.spacexdi.di.modules

import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tasaquino.com.spacexdi.networking.SpacexAPI

val networkingModule = module {
    single { api() }
}

private fun api(): SpacexAPI {
    val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    return retrofit.create(SpacexAPI::class.java)
}