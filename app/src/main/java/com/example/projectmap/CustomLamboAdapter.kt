package com.example.projectmap

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


class CustomLamboAdapter(private val mList: List<LamboViewModel>, val context: Context) : RecyclerView.Adapter<CustomLamboAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lambo_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = mList[position]
        holder.setupView(dataModel.image, dataModel.title, dataModel.description)
        holder.itemView.setOnClickListener{
            // get position if selected item
            val lamboViewModel = mList.get(position)
            // get title etc
            var gTitle : String = lamboViewModel.title
            var gDescription : String = lamboViewModel.description
            // get image with intent
            var gImageView : Int = lamboViewModel.image

            val intent = Intent(context, AventadorDetail::class.java)
            // mindahin data yang diperlukan
            intent.putExtra("iTitle", gTitle)
            intent.putExtra("iDescription", gDescription)
            intent.putExtra("iImageView", gImageView)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var image : ImageView
        var title : TextView
        var description : TextView

        init {
            image = view.findViewById(R.id.car_icon)
            title = view.findViewById(R.id.car_name)
            description = view.findViewById(R.id.car_price)
        }
        fun setupView(imageData: Int, titleData: String, descriptionData: String) {
            image.setImageResource(imageData)
            title.text = titleData
            description.text = descriptionData

            /*itemView.setOnClickListener {
                Toast.makeText(it.context, "Kamu memilih ${titleData}", Toast.LENGTH_SHORT).show()
            }*/

        }
    }
}