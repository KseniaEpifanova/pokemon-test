package ru.ksuta.pokemonowltest.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import ru.ksuta.pokemonowltest.App
import ru.ksuta.pokemonowltest.di.component.AppComponent.Companion.BASE_CTX
import javax.inject.Named

@Module
abstract class AppModule {

    @Binds
    @Named(BASE_CTX)
    abstract fun bindBaseContext(app: App): Context
}