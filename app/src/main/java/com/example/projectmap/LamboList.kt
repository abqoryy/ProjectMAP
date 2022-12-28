package com.example.projectmap


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LamboList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lambo_list)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerviewLambo)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<LamboViewModel>()

        data.add(LamboViewModel(R.drawable.aventador, "Aventador", "Rp9,500,000/Day"))
        data.add(LamboViewModel(R.drawable.gallardo, "Gallardo", "Rp9,500,000/Day"))
        data.add(LamboViewModel(R.drawable.egoista, "Egoista", "Rp12,500,000/Day"))
        data.add(LamboViewModel(R.drawable.gallardo, "Gallardo", "Rp9,500,000/Day"))
        data.add(LamboViewModel(R.drawable.gallardo, "Gallardo", "Rp9,500,000/Day"))
        data.add(LamboViewModel(R.drawable.egoista, "Egoista", "Rp12,500,000/Day"))

        val adapter = CustomLamboAdapter(data, this)
        recyclerview.adapter = adapter

    }
}
