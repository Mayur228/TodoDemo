package com.example.tododemo.feature.homeScreen.presentation.adapter.viewHolder

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.tododemo.R
import com.example.tododemo.feature.homeScreen.model.CalendarData
import java.util.*

class CalendarVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val day = itemView.findViewById<TextView>(R.id.dayTV)
    val date = itemView.findViewById<TextView>(R.id.dateTV)
    val selectedDateV = itemView.findViewById<View>(R.id.selectedDateV)
    private val cal = Calendar.getInstance(Locale.ENGLISH)

    fun bind(item: CalendarData) {
        day.text = item.calendarDay
        date.text = item.calendarDate

        selectedDateV.isVisible = cal[Calendar.DAY_OF_MONTH] == item.calendarDate.toInt()
    }
}