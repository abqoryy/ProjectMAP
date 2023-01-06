package com.example.projectmap.api

import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CustomerinputApi {
    @POST("rest/v1/customer")
    suspend fun create(
        @Header("Authorization") token: String,
        @Header("apikey") apiKey: String,
        @Body customerData: CustomerData
    )
}