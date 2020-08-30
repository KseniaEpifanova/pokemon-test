package ru.ksuta.pokemonowltest.di.module.android

import android.app.Activity
import dagger.Binds
import dagger.Module
import ru.ksuta.pokemonowltest.di.ActivityScope
import ru.ksuta.pokemonowltest.ui.activity.MainActivity

@Module
abstract class MainActivityModule {

	@Binds
	@ActivityScope
	internal abstract fun bindToMainActivity(activity: MainActivity): Activity

}