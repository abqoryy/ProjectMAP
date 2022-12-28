package com.example.projectmap.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface BugattiApi {
    @GET("/rest/v1/bugattilist?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<BugattiItem>>
}