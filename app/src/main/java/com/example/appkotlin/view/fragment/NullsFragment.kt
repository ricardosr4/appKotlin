package com.example.appkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.appkotlin.databinding.FragmentNullsBinding


class NullsFragment : Fragment() {
    private lateinit var binding: FragmentNullsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentNullsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNullsBinding.inflate(layoutInflater)
        return binding.root
    }


}