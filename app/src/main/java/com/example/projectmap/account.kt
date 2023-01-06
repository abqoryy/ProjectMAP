package com.example.projectmap

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class account : AppCompatActivity() {

    lateinit var btnLogOut : Button
    lateinit var namaAccount : TextView
    lateinit var emailAccount : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        btnLogOut = findViewById(R.id.btn_log_out)
        namaAccount = findViewById(R.id.nama_account)
        emailAccount = findViewById(R.id.email_account)

        val sharedPreference = getSharedPreferences(
            "app_preference", Context.MODE_PRIVATE
        )
        var email = sharedPreference.getString("email", "").toString()
        var nama = sharedPreference.getString("nama", "").toString()

        namaAccount.text = nama
        emailAccount.text = email

        btnLogOut.setOnClickListener{
            var editor = sharedPreference.edit()
            editor.clear()
            editor.remove("email")
            editor.commit()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}