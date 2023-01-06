package com.example.projectmap.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface PaganiApi{
    @GET("rest/v1/paganidetail?select=*")
    suspend fun get(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String
    ) : Response<List<PaganiItemDB>>
}