package ru.ksuta.pokemonowltest.repository

import io.reactivex.Single
import ru.ksuta.pokemonowltest.models.PokemonsStats

interface StatRepo {
    fun getStats(id: Int): Single<MutableList<PokemonsStats?>>?
}