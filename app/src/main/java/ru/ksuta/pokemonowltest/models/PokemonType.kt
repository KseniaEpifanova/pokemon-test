package ru.ksuta.pokemonowltest.models

import com.google.gson.annotations.SerializedName

data class PokemonTypes(
    @SerializedName("types") var types:List<PokemonType>
)

data class PokemonType(
    @SerializedName("type") var type:PokeType
)
data class PokeType(
    @SerializedName("name")  var name:String = ""
)