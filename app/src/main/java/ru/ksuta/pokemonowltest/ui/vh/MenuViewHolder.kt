package ru.ksuta.pokemonowltest.ui.vh

import android.view.View
import ru.ksuta.pokemonowltest.databinding.ItemPokemonMenuBinding
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.RemoteDataModel
import ru.ksuta.pokemonowltest.ui.vm.MainMenuViewModel

class MenuViewHolder(binder : ItemPokemonMenuBinding):BaseViewHolder<InfoPokemonModel>(binder.root), View.OnClickListener {

    private var menuVM : MainMenuViewModel = MainMenuViewModel()
    init {
        binder.vm = menuVM

    }
    override fun setData(data: InfoPokemonModel) {
        menuVM.data = data

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}