package tasaquino.com.spacexdi.rockets.infrastructure

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import tasaquino.com.spacexdi.rockets.Rockets
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tasaquino.com.spacexdi.networking.SpacexAPI
import tasaquino.com.spacexdi.rockets.infrastructure.model.Rocket

class RocketsInfrastructure : Rockets.Source {

    override fun fetchRockets(): Observable<List<Rocket>> {

        // TODO: Remover a instância do retrofit e criação do serviço de Rest, prover via DI

        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build()
        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.spacexdata.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api: SpacexAPI = retrofit.create(SpacexAPI::class.java)

        return api.getRockets()
                .subscribeOn(Schedulers.io())
                .map { RocketMapper.map(it) }
    }
}