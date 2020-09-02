package ru.ksuta.pokemonowltest.models

import com.google.gson.annotations.SerializedName

data class InfoPokemonModel(
    @SerializedName("id")  var id: Int? = -1,
    @SerializedName("name") var name: String = "",
    @SerializedName("sprites") var sprites: PokemonSprites? = null,
    @SerializedName("height")  var height: Int? = -1,
    @SerializedName("weight")  var weight: Int? = -1,
    @SerializedName("types") var types: List<PokemonTypes>? = emptyList(),
    @SerializedName("stats") var stats: List<PokemonsStats>? = emptyList()
    )