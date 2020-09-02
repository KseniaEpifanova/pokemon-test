package ru.ksuta.pokemonowltest.ui.vh

import android.view.View
import ru.ksuta.pokemonowltest.databinding.ItemPokemonMenuBinding
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.ui.vm.MainMenuViewModel
import ru.ksuta.pokemonowltest.util.AdapterClickInterface

class MenuViewHolder(
    binder: ItemPokemonMenuBinding,
    private val adapterPokemon: AdapterClickInterface<InfoPokemonModel>
) : BaseViewHolder<InfoPokemonModel>(binder.root), View.OnClickListener {

    private var menuVM: MainMenuViewModel = MainMenuViewModel()

    init {
        binder.vm = menuVM
        binder.card.setOnClickListener(this)
    }

    override fun setData(data: InfoPokemonModel) {
        menuVM.data = data

    }

    override fun onClick(v: View?) {
        adapterPokemon.onItemClicked(absoluteAdapterPosition, menuVM.data)
    }
}