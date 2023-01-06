package com.example.projectmap.api

data class CustomerData (
    val nama : String,
    val alamat : String,
    val email : String? = null,
    val contact : String,
    val durasi : String,
    val mobil : String? = null,
)