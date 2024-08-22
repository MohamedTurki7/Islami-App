package com.route.appislami.ui.chapterDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.route.appislami.R

class VersesAdapter(private val verseList: List<String>) :
    RecyclerView.Adapter<VersesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val verseContent: TextView = itemView.findViewById(R.id.content)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_verse, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = verseList.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val content = verseList[position]
        holder.verseContent.text = "$content(${position + 1})"
    }
}