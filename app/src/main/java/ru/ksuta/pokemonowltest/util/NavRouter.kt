package ru.ksuta.pokemonowltest.util

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class NavRouter(private val fragment: Fragment,private val directions: Int) {

    fun routTo(){
        fragment.findNavController().navigate(directions)
    }
}