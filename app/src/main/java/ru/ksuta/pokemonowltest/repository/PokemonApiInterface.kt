package ru.ksuta.pokemonowltest.repository

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.ksuta.pokemonowltest.models.InfoPokemonModel
import ru.ksuta.pokemonowltest.models.ResultModel


interface PokemonApiInterface {

    /**
     * Получение списка покемонов
     *
     * @return pokemon's data List
     *
     * @see Pokemon
     */
    @GET("pokemon/")
    fun getAllPokemon(@Query("limit") limit: Int,
        @Query("offset") offset: Int): Observable<ResultModel?>?


    /**
     * Получение данных покемона по id
     *
     * @param id - id of pokemon
     *
     * @return pokemon's data
     *
     * @see Pokemon
     */
    @GET("pokemon/{id}")
    fun getPokemonInfo(@Path("id") id: Int): Observable<InfoPokemonModel?>?


    /**
     * Получение данных покемона по name
     *
     * @param name - name of pokemon
     *
     * @return pokemon's data
     *
     * @see Pokemon
     */
    @GET("pokemon/{name}")
    fun getPokemonInfoName(@Path("name") pokemonName: String): Observable<InfoPokemonModel?>?

}