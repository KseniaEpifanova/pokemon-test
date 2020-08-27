package ru.ksuta.pokemonowltest.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.ksuta.pokemonowltest.R
import ru.ksuta.pokemonowltest.util.NavRouter

class SplashFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({
            NavRouter(this, R.id.action_splashFragment_to_mainMenuFragment).routTo()
        }, 1500)
    }
}