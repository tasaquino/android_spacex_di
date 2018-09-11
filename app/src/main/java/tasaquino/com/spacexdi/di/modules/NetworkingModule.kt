package tasaquino.com.spacexdi.di.modules

import org.kodein.di.Kodein
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import tasaquino.com.spacexdi.networking.SpacexAPI
import org.kodein.di.generic.singleton
import org.kodein.di.generic.bind

val networkingModule = Kodein.Module("networkingModule") {

    bind<SpacexAPI>() with singleton {
        Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(SpacexAPI::class.java)
    }
}