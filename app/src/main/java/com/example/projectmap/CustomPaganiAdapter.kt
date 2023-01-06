package com.example.projectmap

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CustomPaganiAdapter(private val mList: List<PaganiViewModel>) : RecyclerView.Adapter<CustomPaganiAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cartype_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mList[position]
        holder.tvCarName.text = data.car_name
        holder.tvCarPrice.text = data.car_price
        holder.tvSeatCapacityDetail.text = data.seat_capacity
        holder.tvTransmissionType.text = data.transmission_type
        holder.tvMaxPower.text = data.max_power
        holder.tvFuelTankCapacity.text = data.fuel_tank
        holder.cardType.setOnClickListener{
            val intent = Intent(holder.cardType.context, AventadorDetail::class.java)
            intent.putExtra("icarName", data.car_name)
            intent.putExtra("icarPrice", data.car_price)
            intent.putExtra("iseatCapacity", data.seat_capacity)
            intent.putExtra("iTransmission", data.max_power)
            intent.putExtra("imaxPower", data.max_power)
            intent.putExtra("ifuelTank", data.fuel_tank)
            holder.cardType.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // buat masukin/lempar data ke detail dari mobil
        /*lateinit var tvSeatCapacityDetail : TextView
        lateinit var tvTransmissionType : TextView
        lateinit var tvMaxPower : TextView
        lateinit var tvFuelTankCapacity : TextView*/


        val cardType : CardView = view.findViewById(R.id.card_car_type)
        val tvCarName : TextView = view.findViewById(R.id.car_name)
        val tvCarPrice : TextView = view.findViewById(R.id.car_price)
        val tvSeatCapacityDetail : TextView = view.findViewById(R.id.seat_capacity)
        val tvTransmissionType : TextView = view.findViewById(R.id.transmission_type)
        val tvMaxPower : TextView = view.findViewById(R.id.max_power)
        val tvFuelTankCapacity : TextView = view.findViewById(R.id.fuel_tank_capacity)

    }
}