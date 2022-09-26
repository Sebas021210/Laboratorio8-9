package com.example.laboratorio8.datasource.api

import com.example.laboratorio8.datasource.model.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DocumentationAPI {
    @GET("/api/character")
    fun getCharacters(): Call<CharactersResponse>

    @GET("/api/character/{id}")
    fun getCharacter(
        @Path("id") id: Int
    ): Call<Character>
}