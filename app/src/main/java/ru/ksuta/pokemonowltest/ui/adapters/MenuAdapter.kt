package ru.ksuta.pokemonowltest.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.ksuta.pokemonowltest.databinding.ItemPokemonMenuBinding
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.RemoteDataModel
import ru.ksuta.pokemonowltest.models.ResultModel
import ru.ksuta.pokemonowltest.repository.MenuRepo
import ru.ksuta.pokemonowltest.ui.vh.MenuViewHolder

class MenuAdapter(private val repo: MenuRepo) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var count: Int = -1

    private var pokemons: MutableList<InfoPokemonModel?> = ArrayList()

    init {

        val r = repo.getPokemonAll()
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.map {
                it.results
            }

            ?.subscribe({

                var l: MutableList<InfoPokemonModel?>? = null
                for (item in it!!) {
                    var res = item.imageURL?.split("/")
                    repo.getPokemon(res?.get(res.size-2)?.toInt()!!)
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe({

                            addToList(it)
                            //Log.i("!!!!!!!!!!!!!!!!!", it.toString())
                            //Log.i("!!!pokemons!!", pokemons.toString())
                        }, {
                            Log.e("eeeeeeeeeeee", it.toString())

                        })
                }
               // setData()

                Log.i("--------------", it.toString())
            }, {
                Log.e("eeeeeeeeeeee", it.toString())
            })


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MenuViewHolder(
            ItemPokemonMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val institutionsListViewHolder = holder as MenuViewHolder

        institutionsListViewHolder.setData(pokemons[position]!!)


    }

    fun addToList(i:InfoPokemonModel?){
    pokemons.add(i)
        notifyDataSetChanged()
}

    fun setData(listPokemon: List<InfoPokemonModel?>) {
        pokemons.addAll(listPokemon)
        notifyDataSetChanged()
    }

}