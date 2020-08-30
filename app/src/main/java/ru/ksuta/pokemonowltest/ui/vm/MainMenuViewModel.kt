package ru.ksuta.pokemonowltest.ui.vm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.RemoteDataModel

class MainMenuViewModel : ViewModel() {
    var data: InfoPokemonModel? = null
        set(value) {
            field = (value)

            imageURL.set(field?.sprites?.front_default)
            name.set(field?.name)
        }

    @JvmField
    val imageURL: ObservableField<String> = ObservableField("")

    @JvmField
    val name: ObservableField<String> = ObservableField("")

}