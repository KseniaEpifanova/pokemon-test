package ru.ksuta.pokemonowltest.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.PokemonSprites
import ru.ksuta.pokemonowltest.models.PokemonType
import ru.ksuta.pokemonowltest.models.ResultModel
import java.security.spec.PSSParameterSpec

interface MenuRepo {

    fun getPokemonToId(id:Int) : Single<InfoPokemonModel?>?

    fun getPokemonAll() : Observable<ResultModel?>?

    //fun getSpiites():Observable<List<PokemonSprites>>
   // fun getTypo():Observable<List<PokemonType>>
}