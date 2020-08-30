package ru.ksuta.pokemonowltest.models

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("next") var next: String? = "",
    @SerializedName("previous") var previous: Boolean? = false,
    @SerializedName("results") var results: List<RemoteDataModel>? = listOf()
)