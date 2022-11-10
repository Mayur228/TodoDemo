package com.example.tododemo.homeScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.tododemo.R
import com.example.tododemo.addToDoFragment.AddToDoFragment
import com.example.tododemo.databinding.ActivityHomeBinding
import com.example.tododemo.homeScreen.adapter.CalendarAdapter
import com.example.tododemo.homeScreen.homeFragment.HomeFragment
import com.example.tododemo.homeScreen.model.CalendarData
import com.example.tododemo.homeScreen.notificationFragment.NotificationFragment
import com.example.tododemo.homeScreen.searchFragment.SearchFragment
import com.example.tododemo.homeScreen.settingFragment.SettingFragment
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class HomeActivity : AppCompatActivity() {
    private val sdf = SimpleDateFormat("MMMM", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)

    private val calendarList = ArrayList<CalendarData>()

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setUpView()
        setUpListener()
    }

    private fun setUpView() {
        binding.monthTV.text = sdf.format(cal.time)
        binding.calendarV.isVisible = false

        binding.monthTV.setOnClickListener {
            binding.calendarV.isVisible = binding.calendarV.isVisible != true
        }

        binding.calendarV.setOnDateChangeListener { calendarView, i, i2, i3 ->
            binding.monthTV.text = sdf.format(calendarView.date)
            cal.time = Date(calendarView.date)
        }
    }

    private fun setUpListener() {
        changeFragment(HomeFragment.newInstance())
        binding.selectedHomeIV.isVisible = true
        binding.selectedSearchIV.isVisible = false
        binding.selectedNotificationIV.isVisible = false
        binding.selectedSettingIV.isVisible = false
        binding.homeIV.isActivated = true
        binding.searchIV.isActivated = false
        binding.notificationIV.isActivated = false
        binding.settingIV.isActivated = false

        binding.homeIV.setOnClickListener {
            changeFragment(HomeFragment.newInstance())
            binding.selectedHomeIV.isVisible = true
            binding.selectedSearchIV.isVisible = false
            binding.selectedNotificationIV.isVisible = false
            binding.selectedSettingIV.isVisible = false
            binding.homeIV.isActivated = true
            binding.searchIV.isActivated = false
            binding.notificationIV.isActivated = false
            binding.settingIV.isActivated = false
        }

        binding.searchIV.setOnClickListener {
            changeFragment(SearchFragment.newInstance())
            binding.selectedHomeIV.isVisible = false
            binding.selectedSearchIV.isVisible = true
            binding.selectedNotificationIV.isVisible = false
            binding.selectedSettingIV.isVisible = false
            binding.homeIV.isActivated = false
            binding.searchIV.isActivated = true
            binding.notificationIV.isActivated = false
            binding.settingIV.isActivated = false
        }

        binding.notificationIV.setOnClickListener {
            changeFragment(NotificationFragment.newInstance())
            binding.selectedHomeIV.isVisible = false
            binding.selectedSearchIV.isVisible = false
            binding.selectedNotificationIV.isVisible = true
            binding.selectedSettingIV.isVisible = false
            binding.homeIV.isActivated = false
            binding.searchIV.isActivated = false
            binding.notificationIV.isActivated = true
            binding.settingIV.isActivated = false
        }

        binding.settingIV.setOnClickListener {
            changeFragment(SettingFragment.newInstance())
            binding.selectedHomeIV.isVisible = false
            binding.selectedSearchIV.isVisible = false
            binding.selectedNotificationIV.isVisible = false
            binding.selectedSettingIV.isVisible = true
            binding.homeIV.isActivated = false
            binding.searchIV.isActivated = false
            binding.notificationIV.isActivated = false
            binding.settingIV.isActivated = true
        }

        binding.addIV.setOnClickListener {
            AddToDoFragment().show(
                supportFragmentManager,
                null
            )
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}