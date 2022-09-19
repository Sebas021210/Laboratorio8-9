package com.example.laboratorio8.datasource.api

import retrofit2.http.GET

interface DocumentationAPI {
    @GET("/character")
    fun getDocumentation()
}