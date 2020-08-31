package ru.ksuta.pokemonowltest.ui.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.RemoteDataModel

class InfoPokemonViewModel : ViewModel() {
    var data: InfoPokemonModel? = null
        set(value) {
            field = (value)

            imageURL.set(field?.sprites?.front_default)
            name.set(field?.name)
            height.set(field?.height)
            weight.set(field?.weight)
            type.set(field?.type)

        }

    @JvmField
    val imageURL: ObservableField<String> = ObservableField("")

    @JvmField
    val name: ObservableField<String> = ObservableField("")

    @JvmField
    val height: ObservableField<Int> = ObservableField()

    @JvmField
    val weight: ObservableField<Int> = ObservableField()

    @JvmField
    val type: ObservableField<String> = ObservableField("")

}