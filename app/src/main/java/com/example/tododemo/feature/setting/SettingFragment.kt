package com.example.tododemo.feature.setting

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.tododemo.R
import com.example.tododemo.databinding.FragmentSettingBinding
import com.example.tododemo.feature.profile.presentation.ProfileActivity

class SettingFragment : Fragment() {

    lateinit var binding: FragmentSettingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_setting, container, false)
        setUpView()

        return binding.root

    }

    private fun setUpView() {
        binding.profileCV.setOnClickListener {
            startActivity(Intent(requireContext(), ProfileActivity::class.java))
        }
    }

    companion object {
        fun newInstance() =
            SettingFragment()
    }
}