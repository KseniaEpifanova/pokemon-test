package ru.ksuta.pokemonowltest.models

import com.google.gson.annotations.SerializedName

data class PokemonSprites (
    @SerializedName("front_default")  var front_default: String? = ""
)