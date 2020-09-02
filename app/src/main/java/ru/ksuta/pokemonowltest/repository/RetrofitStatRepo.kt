package ru.ksuta.pokemonowltest.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.ksuta.pokemonowltest.models.PokemonsStats
import javax.inject.Inject

class RetrofitStatRepo @Inject constructor(private val retrofit:PokemonApiInterface) : StatRepo{
    override fun getStats(id: Int): Single<MutableList<PokemonsStats?>>? {
        return retrofit.getPokemonStats(id) ?.subscribeOn(Schedulers.io())
            ?.observeOn(Schedulers.computation())?.toList()    }
}