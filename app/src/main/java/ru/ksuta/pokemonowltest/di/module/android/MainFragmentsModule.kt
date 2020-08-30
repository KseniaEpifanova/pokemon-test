package ru.ksuta.pokemonowltest.di.module.android


import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.ksuta.pokemonowltest.di.FragmentScope
import ru.ksuta.pokemonowltest.ui.fragment.MainMenuFragment
import ru.ksuta.pokemonowltest.ui.fragment.SplashFragment

@Module
abstract class MainFragmentsModule {


	@FragmentScope
	@ContributesAndroidInjector
	internal abstract fun bindSplashFragment(): SplashFragment

	@FragmentScope
	@ContributesAndroidInjector
	internal abstract fun bindMainMenuFragment(): MainMenuFragment



}