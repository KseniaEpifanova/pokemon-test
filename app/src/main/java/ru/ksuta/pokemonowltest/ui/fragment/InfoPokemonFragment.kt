package ru.ksuta.pokemonowltest.ui.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.AndroidSupportInjection
import ru.ksuta.pokemonowltest.databinding.FragmentInfoPokemonBinding
import ru.ksuta.pokemonowltest.di.FragmentScope
import ru.ksuta.pokemonowltest.repository.MenuRepo
import ru.ksuta.pokemonowltest.ui.vm.InfoPokemonViewModel
import javax.inject.Inject


@FragmentScope
class InfoPokemonFragment : Fragment() {

    @set:Inject
    internal lateinit var repo: MenuRepo

    private var infoVM: InfoPokemonViewModel = InfoPokemonViewModel()

    private lateinit var binding: FragmentInfoPokemonBinding


    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentInfoPokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("CheckResult")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val idPoke = arguments?.getString("idPoke")
        binding.infoVM = infoVM

        if (idPoke != null) {
            infoVM.update(idPoke,repo)
        }
    }


}