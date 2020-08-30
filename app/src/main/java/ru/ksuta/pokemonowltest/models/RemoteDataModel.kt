package ru.ksuta.pokemonowltest.models

import com.google.gson.annotations.SerializedName

data class RemoteDataModel (
                            @SerializedName("name") var name: String = "",
                            @SerializedName("url") var imageURL: String? = null
                            )