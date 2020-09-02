package ru.ksuta.pokemonowltest.repository

import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import ru.ksuta.pokemonowltest.di.module.RetrofitServiceModule
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.ResultModel
import javax.inject.Inject

class RetrofitMenuRepo  @Inject constructor( private val retrofit:PokemonApiInterface) : MenuRepo {



    override fun getPokemonToId(id: Int): Single<InfoPokemonModel?>? {
        return retrofit.getPokemonInfo(id) ?.subscribeOn(Schedulers.io())
            ?.observeOn(Schedulers.computation())?.firstElement()?.toSingle()
    }

    override fun getPokemonAll(limit: Int, offset:Int): Observable<ResultModel?>? {
        return retrofit.getAllPokemon(limit,offset)?.subscribeOn(Schedulers.io())
            ?.observeOn(Schedulers.computation())

    }
}