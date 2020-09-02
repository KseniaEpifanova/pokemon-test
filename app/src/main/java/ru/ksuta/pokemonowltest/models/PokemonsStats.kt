package ru.ksuta.pokemonowltest.models

import com.google.gson.annotations.SerializedName

data class PokemonsStats(
    @SerializedName("stats")  var stats:List<PokemonsStat> = listOf()
)
data class PokemonsStat(
    @SerializedName("stat")  var stat:PokeStat
)
data class PokeStat(
    @SerializedName("name")  var name:String = ""
)