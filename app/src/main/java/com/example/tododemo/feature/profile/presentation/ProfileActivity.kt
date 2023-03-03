package com.example.tododemo.feature.profile.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.tododemo.R
import com.example.tododemo.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    var binding: ActivityProfileBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_profile)


    }
}