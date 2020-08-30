package ru.ksuta.pokemonowltest.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import dagger.android.support.AndroidSupportInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.ksuta.pokemonowltest.databinding.FragmentMenuBinding
import ru.ksuta.pokemonowltest.di.FragmentScope
import ru.ksuta.pokemonowltest.repository.MenuRepo
import ru.ksuta.pokemonowltest.repository.PokemonApiInterface
import ru.ksuta.pokemonowltest.ui.adapters.MenuAdapter
import javax.inject.Inject

@FragmentScope
class MainMenuFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {

    @set:Inject
    internal lateinit var repo: MenuRepo

    private lateinit var menuAdapter: MenuAdapter

    private lateinit var binding: FragmentMenuBinding

    @set:Inject
    internal lateinit var api: PokemonApiInterface

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        menuAdapter = MenuAdapter(repo)
       // buildService(PokemonApiInterface)
        //ServiceBuilder.buildService(PokemonApiInterface)
        binding.adapterList = menuAdapter





    }

    override fun onRefresh() {
        TODO("Not yet implemented")
    }

}