package ru.ksuta.pokemonowltest.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import ru.ksuta.pokemonowltest.App
import ru.ksuta.pokemonowltest.di.ApplicationScope
import ru.ksuta.pokemonowltest.di.module.AppModule
import ru.ksuta.pokemonowltest.di.module.RepoModule
import ru.ksuta.pokemonowltest.di.module.RetrofitServiceModule
import ru.ksuta.pokemonowltest.di.module.android.ActivitiesModule

@ApplicationScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        RepoModule::class,
        RetrofitServiceModule::class
    ]
)
interface AppComponent {

    companion object {
        const val BASE_CTX = "base_context"
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app : App) : Builder

        fun build() : AppComponent
    }

    fun inject(app : App)
}