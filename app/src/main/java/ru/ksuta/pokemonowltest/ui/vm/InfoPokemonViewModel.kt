package ru.ksuta.pokemonowltest.ui.vm

import android.annotation.SuppressLint
import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.databinding.PropertyChangeRegistry
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.RemoteDataModel
import ru.ksuta.pokemonowltest.repository.MenuRepo

class InfoPokemonViewModel : ViewModel() {

    var info: InfoPokemonModel? = null
        set(value) {
            field = (value)
            name.set(field?.name)
            imageURL.set(field?.sprites?.front_default)
            height.set(field?.height.toString())
            weight.set(field?.weight.toString())
           // types.set(field?.types?.get(1).toString())
        }
    @JvmField
    val name: ObservableField<String> = ObservableField("")

    @JvmField
    val imageURL: ObservableField<String> = ObservableField("")

    @JvmField
    val height: ObservableField<String> = ObservableField("")

    @JvmField
    val weight: ObservableField<String> = ObservableField("")

    @JvmField
    val types: ObservableField<String> = ObservableField("")

    @JvmField
    val stats: ObservableField<String> = ObservableField("")



    @SuppressLint("CheckResult")
    fun update(idPoke: String, repo: MenuRepo){
        repo.getPokemonToId(idPoke.toInt())?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe({
                Log.i("!!!!!!!!!!!!!!!!!!!", it.toString())
                this.info = it
            }, {
                Log.e("err", it.toString())
            })
    }
}