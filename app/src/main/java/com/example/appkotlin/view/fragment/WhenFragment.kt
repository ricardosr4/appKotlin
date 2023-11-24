package com.example.appkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.appkotlin.databinding.FragmentWhenBinding


class WhenFragment : Fragment() {
    private lateinit var binding: FragmentWhenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentWhenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWhenBinding.inflate(layoutInflater)
        return binding.root
    }


}