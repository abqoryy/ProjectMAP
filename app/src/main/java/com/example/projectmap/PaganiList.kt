package com.example.projectmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmap.api.PaganiApi
import com.example.projectmap.api.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PaganiList : AppCompatActivity() {
    lateinit var rc : RecyclerView
    lateinit var data : ArrayList<PaganiViewModel>

    val apiKey =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xYmVhenFsbWNvZGlobnVsd2JpIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzE4NDExODUsImV4cCI6MTk4NzQxNzE4NX0.3-yenxirSlcP5fyvGXQx6W4qUHD0guq-xQ3q5jj3Sgo"
    val token = "Bearer $apiKey"

    val carApi = RetrofitHelper.getInstance().create(PaganiApi::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagani_list)

        rc = findViewById(R.id.recyclerviewPagani)
        data = ArrayList()
        rc.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        CoroutineScope(Dispatchers.Main).launch {
            val response = carApi.get(token = token, apiKey = apiKey)
            response.body()?.forEach{
                data.add(
                    PaganiViewModel(
                        id = it.id,
                        car_name = it.car_name,
                        car_price = it.price,
                        fuel_tank = it.fuel_tank,
                        transmission_type = it.transmission_type,
                        seat_capacity = it.seat_capacity,
                        max_power = it.max_power,
                    )
                )
            }
            val adapter = CustomPaganiAdapter(data)
            rc.adapter = adapter
        }
    }
}