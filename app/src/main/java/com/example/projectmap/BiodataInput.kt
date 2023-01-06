package com.example.projectmap

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.projectmap.api.CustomerData
import com.example.projectmap.api.RetrofitHelper
import com.example.projectmap.api.CustomerinputApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BiodataInput : AppCompatActivity(){

    lateinit var btnPesanFinal : Button
    lateinit var etNameBiodata : EditText
    lateinit var etAddressBiodata : EditText
    lateinit var etContactBiodata : EditText
    lateinit var etDurasiPesan : EditText

    val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xYmVhenFsbWNvZGlobnVsd2JpIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzE4NDExODUsImV4cCI6MTk4NzQxNzE4NX0.3-yenxirSlcP5fyvGXQx6W4qUHD0guq-xQ3q5jj3Sgo"
    val token = "Bearer $apiKey"
    val custApi = RetrofitHelper.getInstance().create(CustomerinputApi::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biodata_input)

        btnPesanFinal = findViewById(R.id.btn_pesan_final)
        etNameBiodata = findViewById(R.id.et_name_biodata)
        etAddressBiodata = findViewById(R.id.et_address_biodata)
        etContactBiodata = findViewById(R.id.et_contact_biodata)
        etDurasiPesan = findViewById(R.id.kotak_durasi)


        btnPesanFinal.setOnClickListener{
            CoroutineScope(Dispatchers.Main).launch{
                var mobil = intent.getStringExtra("mobil")
                val sharedPreference = getSharedPreferences(
                    "app_preference", Context.MODE_PRIVATE
                )
                val email = sharedPreference.getString("email", "").toString()
                val data = CustomerData(
                    mobil = mobil,
                    email = email,
                    nama = etNameBiodata.text.toString(),
                    alamat = etAddressBiodata.text.toString(),
                    contact = etContactBiodata.text.toString(),
                    durasi = etDurasiPesan.text.toString())

                val response = custApi.create(token = token, apiKey = apiKey, customerData = data)

                Toast.makeText(
                    applicationContext,
                    "Berhasil Memesan !",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
}
