package com.example.appkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.appkotlin.databinding.FragmentVarValBinding


class VarValFragment : Fragment() {
    private lateinit var binding: FragmentVarValBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentVarValBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVarValBinding.inflate(layoutInflater)
        return binding.root
    }


}