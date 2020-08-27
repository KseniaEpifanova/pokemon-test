package ru.ksuta.pokemonowltest.models

data class InfoPokemonModel(
    var id: Int = -1,
    var name: String = "",
    var imageURL: List<PokemonSprites> = emptyList(),
    var height: Int = -1,
    var weight: Int = -1,
    var type: List<PokemonType> = emptyList()
   // var stats: List<> = emptyList()
    )