package ru.ksuta.pokemonowltest.util

interface AdapterClickInterface<T> {
    fun onItemClicked(pos: Int, item: T?)
}