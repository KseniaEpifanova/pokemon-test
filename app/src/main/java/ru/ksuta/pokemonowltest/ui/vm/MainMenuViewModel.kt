package ru.ksuta.pokemonowltest.ui.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.RemoteDataModel

class MainMenuViewModel : ViewModel() {
    var data: InfoPokemonModel? = null
        set(value) {
            field = (value)
            id.set(field?.id.toString())
            imageURL.set(field?.sprites?.front_default)
            name.set(field?.name)
        }

    @JvmField
    val id: ObservableField<String> = ObservableField("")

    @JvmField
    val imageURL: ObservableField<String> = ObservableField("")

    @JvmField
    val name: ObservableField<String> = ObservableField("")

}