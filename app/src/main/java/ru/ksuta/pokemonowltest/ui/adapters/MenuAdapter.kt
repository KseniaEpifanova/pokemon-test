package ru.ksuta.pokemonowltest.ui.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.ksuta.pokemonowltest.databinding.ItemPokemonMenuBinding
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.repository.MenuRepo
import ru.ksuta.pokemonowltest.ui.vh.MenuViewHolder
import ru.ksuta.pokemonowltest.util.AdapterClickInterface

class MenuAdapter(
    private val repo: MenuRepo,
    private val adapterPokemon: AdapterClickInterface<InfoPokemonModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var count: Int = 0
    private var pokemons: MutableList<InfoPokemonModel?> = ArrayList()

    init {
        loadData(count)
        count = 30
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MenuViewHolder(
            ItemPokemonMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), adapterPokemon
        )
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position == itemCount - 1) {
            loadData(count)
        }
        val institutionsListViewHolder = holder as MenuViewHolder
        institutionsListViewHolder.setData(pokemons[position]!!)
    }

    fun addToList(i: InfoPokemonModel?) {
        pokemons.add(i)
        notifyItemChanged(count)
    }

    // загрузка данных
    @SuppressLint("CheckResult")
     fun loadData(i: Int) {
        repo.getPokemonAll(30, i)
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.map { it.results }
            ?.subscribe({ list ->
                var l: MutableList<InfoPokemonModel?>? = null
                for (item in list!!) {
                    val res = item.imageURL?.split("/")
                    repo.getPokemonToId(res?.get(res.size - 2)?.toInt()!!)
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe({
                            addToList(it)
                            Log.i("!!!!!!!!!!!!!!!!!!!", it.toString())

                        }, {
                            Log.e("err", it.toString())
                        })
                }
            }, {
                Log.e("err", it.toString())
            })
    }
}