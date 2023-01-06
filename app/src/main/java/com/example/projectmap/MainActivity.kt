package com.example.projectmap


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.projectmap.api.BrandApi
import com.example.projectmap.api.RetrofitHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var listBrand : ListView
    lateinit var txtHaloUser : TextView
    lateinit var accountIcon : ImageView

    val apiKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Im9xYmVhenFsbWNvZGlobnVsd2JpIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NzE4NDExODUsImV4cCI6MTk4NzQxNzE4NX0.3-yenxirSlcP5fyvGXQx6W4qUHD0guq-xQ3q5jj3Sgo"
    val token = "Bearer $apiKey"

    val Items = ArrayList<Model>()
    val brandApi = RetrofitHelper.getInstance().create(BrandApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listBrand = findViewById(R.id.carbrand_list)
        txtHaloUser = findViewById(R.id.halo_user)
        accountIcon = findViewById(R.id.account_icon)

        val sharedPreference =  getSharedPreferences(
            "app_preference", Context.MODE_PRIVATE
        )

        var nama = sharedPreference.getString("nama", "").toString()
        txtHaloUser.text = nama

        CoroutineScope(Dispatchers.Main).launch {
            val response = brandApi.get(token=token, apiKey=apiKey)

            response.body()?.forEach {
                Items.add(
                    Model(
                        Id=it.id,
                        Brand=it.brand,
                        img = it.img,
                    )
                )
            }
            setList(Items)
        }

        accountIcon.setOnClickListener{
            val intent = Intent(this, account::class.java)
            startActivity(intent)
        }

        listBrand.setOnItemClickListener { adapterView, view, position, id ->
            // lamborghini
            if(position==0){
                val intent = Intent(this, LamboList::class.java)
                startActivity(intent)
            }
            // bugatti
            else if(position==1){
                val intent = Intent(this, BugattiList::class.java)
                startActivity(intent)
            }
            // pagani
            else if(position==2){
                val intent = Intent(this, PaganiList::class.java)
                startActivity(intent)
            }
            // porsche
            else if(position==3){
                val intent = Intent(this, PorscheList::class.java)
                startActivity(intent)
            }
            // ferrari
            else if(position==4){
                val intent = Intent(this, FerrariList::class.java)
                startActivity(intent)
            }
            return@setOnItemClickListener
        }
    }
    fun setList(Items: ArrayList<Model>) {
        val adapter = BrandAdapter(this, R.layout.brand_item, Items)
        listBrand.adapter = adapter
    }
}

