package com.example.projectmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class AventadorDetail : AppCompatActivity() {

    lateinit var btnPesan : ImageButton
    lateinit var carIcon : ImageView
    lateinit var carTitle : TextView
    lateinit var carPrice : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aventador_detail)

        btnPesan = findViewById(R.id.btn_pesan)
        carIcon = findViewById(R.id.car_image)
        carTitle = findViewById(R.id.car_title)
        carPrice = findViewById(R.id.car_price)

        var intent = intent
        val cTitle = intent.getStringExtra("iTitle")
        val cPrice = intent.getStringExtra("iDescription")
        val cIcon = intent.getIntExtra("iImageView", 0)

        carTitle.text = cTitle
        carPrice.text = cPrice
        carIcon.setImageResource(cIcon)

        btnPesan.setOnClickListener{
            Toast.makeText(
                this,
                "Please input your Name",
                Toast.LENGTH_SHORT
            ).show()
            return@setOnClickListener
        }
    }
}