package com.example.tododemo.homeScreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tododemo.R
import com.example.tododemo.homeScreen.adapter.viewHolder.CalendarVH
import com.example.tododemo.homeScreen.model.CalendarData

class CalendarAdapter: RecyclerView.Adapter<CalendarVH>() {
    var list:List<CalendarData> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    interface CalendarInterface {
        fun onSelect(calendarData: CalendarData, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_date,parent,false)
        return CalendarVH(view)
    }

    override fun onBindViewHolder(holder: CalendarVH, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}