package com.example.projectmap.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface LamboApi {
    @GET("/rest/v1/lambolist?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<LamboItem>>
}