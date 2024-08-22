package com.route.appislami.ui.home.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.appislami.R

class ChaptersRecycleAdapter(val chapters: List<String>) :
    RecyclerView.Adapter<ChaptersRecycleAdapter.ViewHolder>() {
    var onItemClickListener: OnItemClickListener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tittle: TextView = itemView.findViewById(R.id.chapter_tittle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chapter, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = chapters.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tittle = chapters[position]
        holder.tittle.setText(tittle)
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, tittle)
            }
        }
    }

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, tittle: String)
    }

}