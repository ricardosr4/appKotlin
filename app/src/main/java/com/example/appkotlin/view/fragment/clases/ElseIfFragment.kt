package com.example.appkotlin.view.fragment.clases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.appkotlin.databinding.FragmentElseIfBinding


class ElseIfFragment : Fragment() {
    private lateinit var binding: FragmentElseIfBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentElseIfBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentElseIfBinding.inflate(layoutInflater)
        return  binding.root
    }



}