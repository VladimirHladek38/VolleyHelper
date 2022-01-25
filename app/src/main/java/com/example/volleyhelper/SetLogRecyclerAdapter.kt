package com.example.volleyhelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SetLogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<String> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return SetLogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.set_log_recycler_view, parent, false)
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is SetLogViewHolder -> {
                holder.bind(items[position])
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    fun postItemsList(data: ArrayList<String>) {
        items = data
    }
    class SetLogViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val eventTextView: TextView = itemView.findViewById(R.id.eventTextView)

        fun bind(setLogLine: String) {
            eventTextView.text = setLogLine
        }
    }
}