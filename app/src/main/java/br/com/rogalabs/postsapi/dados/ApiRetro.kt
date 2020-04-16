package br.com.rogalabs.postsapi.dados

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiRetro {

    private fun iniciarRetro(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    val service: RetroMethods = iniciarRetro().create(RetroMethods::class.java)
}