package com.example.quake.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quake.R
import com.example.quake.data.api.response.QuakeResults

class QuakeAdapter : RecyclerView.Adapter<QuakeAdapter.ViewHolder>() {

    private var itemList: ArrayList<QuakeResults> = arrayListOf()

    fun set(itemList: ArrayList<QuakeResults>) {
        this.itemList.clear()
        this.itemList.addAll(itemList)
        notifyDataSetChanged()
    }

    fun setAll(itemList: ArrayList<QuakeResults>) {
        this.itemList.addAll(this.itemList.size, itemList)
        notifyDataSetChanged()
    }

    fun get(position: Int): QuakeResults {
        return itemList[position]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val sizeTV: TextView = view.findViewById(R.id.sizeTV)
        private val qualityTV: TextView = view.findViewById(R.id.qualityTV)
        private val humanReadableLocationTV: TextView =
            view.findViewById(R.id.humanReadableLocationTV)

        fun bind(
            item: QuakeResults?,
            position: Int,
        ) {
            if (item != null) {
                try {
                    ("Size: " + item.size.toString()).also { sizeTV.text = it }
                    ("Quality: " + item.quality.toString()).also { qualityTV.text = it }
                    ("Location: " + item.humanReadableLocation.toString()).also {
                        humanReadableLocationTV.text = it
                    }


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quake, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position], position)
    }
}