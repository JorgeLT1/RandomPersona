package com.example.randomwomen.data.remote.dto

import retrofit2.http.GET


interface PersonaApi {
    @GET("api/?gender=female&?page=3&results=10&seed=abc")
    suspend fun getPersons(): results
}