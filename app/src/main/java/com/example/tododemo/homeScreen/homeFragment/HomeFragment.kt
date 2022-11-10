package com.example.tododemo.homeScreen.homeFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tododemo.R
import com.example.tododemo.homeScreen.adapter.CalendarAdapter
import com.example.tododemo.homeScreen.model.CalendarData
import java.util.*

class HomeFragment : Fragment() {
    private val cal = Calendar.getInstance(Locale.ENGLISH)

    lateinit var adapter: CalendarAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView(view)
        getDates()
    }

    private fun setUpView(view: View) {
        adapter = CalendarAdapter()

        val dateRV = view.findViewById<RecyclerView>(R.id.dateRV)
        dateRV.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        dateRV.adapter = adapter

    }


    private fun getDates() {
        val dateList = ArrayList<CalendarData>() // For our Calendar Data Class
        val dates = ArrayList<Date>() // For Date

        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)

        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)

        while (dates.size < maxDaysInMonth) {

            dates.add(monthCalendar.time)
            dateList.add(CalendarData(monthCalendar.time))

            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)   // Increment Day By 1
        }

        adapter.list = dateList
    }

    companion object {
        fun newInstance() =
            HomeFragment()
    }
}