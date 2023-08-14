package com.example.restcountriesproject.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.restcountriesproject.R
import com.example.restcountriesproject.ThirdActivity
import com.example.restcountriesproject.data_package.Country

class RecyclerViewAdapter(var listOfCountries : List<Country>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    lateinit var context: Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flagImageView: ImageView = itemView.findViewById(R.id.imageView4)
        val textViewHehe: TextView = itemView.findViewById(R.id.textView3)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.recycler_view_row, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerViewAdapter.ViewHolder, position: Int) {

        viewHolder.textViewHehe.text = listOfCountries.get(position).name!!.common.toString()

        Glide.with(context)
            .load(listOfCountries.get(position).flags!!.png)
            .into(viewHolder.flagImageView)

        viewHolder.itemView.setOnClickListener{
            val thirdActivityIntent = Intent(context,ThirdActivity::class.java)
            thirdActivityIntent.putExtra("flagPngKey", listOfCountries.get(position).flags!!.png)
            thirdActivityIntent.putExtra("commonNameKey", listOfCountries.get(position).name!!.common.toString())
            thirdActivityIntent.putExtra("officialNameKey", listOfCountries.get(position).name!!.official.toString())
            thirdActivityIntent.putExtra("areaKey", listOfCountries.get(position).area)

            if(listOfCountries.get(position).capital.isNotEmpty())
                thirdActivityIntent.putExtra("capitalKey", listOfCountries.get(position).capital.get(0))
            else
                thirdActivityIntent.putExtra("capitalKey","no capital")

            thirdActivityIntent.putExtra("flagAltKey", listOfCountries.get(position).flags!!.alt)
            context.startActivity(thirdActivityIntent)
        }

    }

    override fun getItemCount(): Int {
        return listOfCountries.size
    }
    fun setFilteredList (listOfCountries: List<Country>){
        this.listOfCountries = listOfCountries
        notifyDataSetChanged()
    }
}