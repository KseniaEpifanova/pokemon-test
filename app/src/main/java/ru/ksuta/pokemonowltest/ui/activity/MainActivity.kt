package ru.ksuta.pokemonowltest.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.ksuta.pokemonowltest.R
import ru.ksuta.pokemonowltest.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
	@set:Inject
	internal lateinit var dispatchingFragmentInjector : DispatchingAndroidInjector<Fragment>


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		AndroidInjection.inject(this)

	}
	override fun supportFragmentInjector() : AndroidInjector<Fragment> = dispatchingFragmentInjector

}