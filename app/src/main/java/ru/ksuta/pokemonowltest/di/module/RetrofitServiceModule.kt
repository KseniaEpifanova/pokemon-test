package ru.ksuta.pokemonowltest.di.module

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.ksuta.pokemonowltest.repository.PokemonApiInterface
import ru.ksuta.pokemonowltest.repository.RetrofitMenuRepo
import javax.inject.Singleton

@Module
class RetrofitServiceModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return  Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun buildService(retrofit: Retrofit): PokemonApiInterface {
        return retrofit.create(PokemonApiInterface::class.java)
    }


}