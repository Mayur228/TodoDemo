package com.example.tododemo.feature.homeScreen.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tododemo.R
import com.example.tododemo.feature.addToDoFragment.AddToDoFragment
import com.example.tododemo.databinding.ActivityHomeBinding
import com.example.tododemo.feature.homeScreen.model.CalendarData
import com.example.tododemo.feature.notification.NotificationFragment
import com.example.tododemo.feature.profile.presentation.ProfileActivity
import com.example.tododemo.feature.search.SearchFragment
import com.example.tododemo.feature.setting.SettingFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private val sdf = SimpleDateFormat("MMMM", Locale.ENGLISH)
    private val cal = Calendar.getInstance(Locale.ENGLISH)

    private val calendarList = ArrayList<CalendarData>()

    val viewModel by viewModels<HomeViewModel>()

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setUpView()
        setUpListener()
        observeEvent()
    }

    private fun setUpView() {
        binding.monthTV.text = sdf.format(cal.time)
        binding.calendarV.isVisible = false

        binding.monthTV.setOnClickListener {
            binding.calendarV.isVisible = binding.calendarV.isVisible != true
        }

        binding.calendarV.setOnDateChangeListener { calendarView, i, i2, i3 ->
//            val month = sdf.format(i2)
            Log.e("CHECK",i2.toString())
            binding.monthTV.text = sdf.format(calendarView.date)
            cal.time = Date(calendarView.date)
        }
        /*binding.calendarV.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val Date = (dayOfMonth.toString() + "-"
                    + (month + 1) + "-" + year)

            Log.e("CHECK",Date)
        }*/
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
            viewModel.redirectToHome()
        }

        binding.searchIV.setOnClickListener {
            viewModel.redirectToSearch()
        }

        binding.notificationIV.setOnClickListener {
           viewModel.redirectToNotification()
        }

        binding.settingIV.setOnClickListener {
           viewModel.redirectToSetting()
        }

        binding.addIV.setOnClickListener {
           viewModel.openToDo()
        }

        binding.profileBGV.setOnClickListener {
            viewModel.openProfile()
        }
    }

    private fun observeEvent() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.redirectToHomeEvent.collect {
                        binding.monthTV.isVisible = true
                        binding.profileBGV.isVisible = true
                        binding.profileIV.isVisible = true
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
                }

                launch {
                    viewModel.redirectToSearchEvent.collect {
                        binding.monthTV.isVisible = true
                        binding.profileBGV.isVisible = true
                        binding.profileIV.isVisible = true
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
                }

                launch {
                    viewModel.redirectToNotificationEvent.collect {
                        binding.monthTV.isVisible = true
                        binding.profileBGV.isVisible = true
                        binding.profileIV.isVisible = true
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
                }

                launch {
                    viewModel.redirectToSettingEvent.collect {
                        binding.monthTV.isVisible = false
                        binding.profileBGV.isVisible = false
                        binding.profileIV.isVisible = false
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
                }

                launch {
                    viewModel.openAddToDoEvent.collect{
                        binding.addToDoFragmentContainer.isVisible = true
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.addToDoFragmentContainer, AddToDoFragment.newInstance())
                            .commit()
                    }
                }

                launch {
                    viewModel.openProfileEvent.collect{
                        startActivity(Intent(applicationContext,ProfileActivity::class.java))
                    }
                }
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        binding.addToDoFragmentContainer.isVisible = false
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}