package ru.ksuta.pokemonowltest.di.module

import dagger.Binds
import dagger.Module
import ru.ksuta.pokemonowltest.repository.MenuRepo
import ru.ksuta.pokemonowltest.repository.RetrofitMenuRepo

@Module
abstract class RepoModule {

    @Binds
    abstract fun bindsRepo(repo : RetrofitMenuRepo) : MenuRepo
}