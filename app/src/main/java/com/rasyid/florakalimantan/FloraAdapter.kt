package com.rasyid.florakalimantan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FloraAdapter(private val listFlora: ArrayList<Flora>) : RecyclerView.Adapter<FloraAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPhoto: ImageView = itemView.findViewById(R.id.iv_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvDesc: TextView = itemView.findViewById(R.id.tv_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_flora, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFlora.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, photo) = listFlora[position]
        holder.ivPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDesc.text = desc
    }
}