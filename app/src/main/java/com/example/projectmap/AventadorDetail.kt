package com.example.projectmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class AventadorDetail : AppCompatActivity() {

    lateinit var btnPesan : ImageButton
    lateinit var carIcon : ImageView
    lateinit var carTitle : TextView
    lateinit var carPrice : TextView
    lateinit var tvSeatCapacityDetail : TextView
    lateinit var tvTransmissionType : TextView
    lateinit var tvMaxPower : TextView
    lateinit var tvFuelTankCapacity : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aventador_detail)

        btnPesan = findViewById(R.id.btn_pesan)
        carIcon = findViewById(R.id.car_image)
        carTitle = findViewById(R.id.car_title)
        carPrice = findViewById(R.id.car_price)
        tvSeatCapacityDetail = findViewById(R.id.seat_capacity)
        tvTransmissionType = findViewById(R.id.transmission_type)
        tvMaxPower = findViewById(R.id.max_power)
        tvFuelTankCapacity = findViewById(R.id.fuel_tank_capacity)


        val cTitle = intent.getStringExtra("icarName")
        val cPrice = intent.getStringExtra("icarPrice")
        val cSeat = intent.getStringExtra("iseatCapacity")
        val cTransmission = intent.getStringExtra("iTransmission")
        val cMaxPower = intent.getStringExtra("imaxPower")
        val cfuelTank = intent.getStringExtra("ifuelTank")
        val cCarIcon = intent.getStringExtra("iCarIcon")

        carTitle.text = cTitle
        carPrice.text = cPrice
        tvSeatCapacityDetail.text = cSeat
        tvTransmissionType.text = cTransmission
        tvMaxPower.text = cMaxPower
        tvFuelTankCapacity.text = cfuelTank
        Glide.with(this).load(cCarIcon).into(carIcon)

        var intentTitleCar = cTitle

        btnPesan.setOnClickListener{
            val intent = Intent(this, BiodataInput::class.java)
            intent.putExtra("mobil", intentTitleCar)
            startActivity(intent)
        }
    }
}