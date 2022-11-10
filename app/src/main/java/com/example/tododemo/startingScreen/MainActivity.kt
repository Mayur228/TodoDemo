package com.example.tododemo.startingScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tododemo.R
import com.example.tododemo.databinding.ActivityMainBinding
import com.example.tododemo.homeScreen.HomeActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUp()
    }

    private fun setUp() {
        binding.startBtn.setOnClickListener {
            startActivity(Intent(applicationContext,HomeActivity::class.java))
        }
    }
}