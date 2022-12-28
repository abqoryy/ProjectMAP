package com.example.projectmap


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class BrandAdapter (var ctx: Context, var resource: Int, var item: ArrayList<Model>): ArrayAdapter<Model>(ctx, resource, item) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(ctx)
        val view = layoutInflater.inflate(resource, null)

        val brand = view.findViewById<TextView>(R.id.merek_mobil)

        brand.text = item[position].Brand

        return view
    }
}


