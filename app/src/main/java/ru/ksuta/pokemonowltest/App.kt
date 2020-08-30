package ru.ksuta.pokemonowltest

import android.app.Activity
import android.app.Fragment
import androidx.multidex.MultiDexApplication
import dagger.android.*
import ru.ksuta.pokemonowltest.di.component.DaggerAppComponent
import javax.inject.Inject

class App : MultiDexApplication(), HasActivityInjector {

    @set:Inject
    internal lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .application(this)
            .build().inject(this)
    }
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector



}