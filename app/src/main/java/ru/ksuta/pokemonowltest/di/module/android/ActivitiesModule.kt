package ru.ksuta.pokemonowltest.di.module.android


import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.ksuta.pokemonowltest.di.ActivityScope
import ru.ksuta.pokemonowltest.di.module.RepoModule
import ru.ksuta.pokemonowltest.ui.activity.MainActivity

@Module
abstract class ActivitiesModule{

	@ActivityScope
	@ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentsModule::class, RepoModule::class])
	internal abstract fun bindMainActivities(): MainActivity

}