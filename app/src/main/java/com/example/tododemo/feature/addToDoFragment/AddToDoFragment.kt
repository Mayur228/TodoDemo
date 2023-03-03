package com.example.tododemo.feature.addToDoFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tododemo.R

class AddToDoFragment : Fragment() {

    companion object {
        fun newInstance(): AddToDoFragment {
            val fragment = AddToDoFragment()
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_do, container, false)
    }



}