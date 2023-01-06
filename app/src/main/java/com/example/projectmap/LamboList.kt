package com.example.projectmap


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmap.api.LamboApi
import com.example.projectmap.api.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LamboList : AppCompatActivity() {

    lateinit var rcLambo : RecyclerView
    lateinit var data : ArrayList<LamboViewModel>

    val apiKey =
        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xYmVhenFsbWNvZGlobnVsd2JpIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzE4NDExODUsImV4cCI6MTk4NzQxNzE4NX0.3-yenxirSlcP5fyvGXQx6W4qUHD0guq-xQ3q5jj3Sgo"
    val token = "Bearer $apiKey"

    val lamboApi = RetrofitHelper.getInstance().create(LamboApi::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambo_list)

        rcLambo = findViewById(R.id.recyclerviewLambo)
        data = ArrayList()
        rcLambo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        CoroutineScope(Dispatchers.Main).launch {
            val response = lamboApi.get(token = token, apiKey = apiKey)
                response.body()?.forEach{
                    data.add(
                        LamboViewModel(
                            id = it.id,
                            car_name = it.car_name,
                            car_price = it.price,
                            fuel_tank = it.fuel_tank,
                            transmission_type = it.transmission_type,
                            seat_capacity = it.seat_capacity,
                            max_power = it.max_power,
                            img = it.img,
                        )
                    )
                }
            val adapter = CustomLamboAdapter(data)
            rcLambo.adapter = adapter
        }
    }
}

