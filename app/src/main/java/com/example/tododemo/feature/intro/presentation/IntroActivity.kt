package com.example.tododemo.feature.intro.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.tododemo.R
import com.example.tododemo.databinding.ActivityMainBinding
import com.example.tododemo.feature.homeScreen.presentation.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class IntroActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<IntroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUp()
        observerEvent()
    }

    private fun setUp() {
        binding.startBtn.setOnClickListener {
            viewModel.redirectToHome()
        }
    }

    private fun observerEvent() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.redirectToHome.collect {
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
                    }
                }
            }
        }
    }
}