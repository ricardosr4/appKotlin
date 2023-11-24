package com.example.appkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.appkotlin.R
import com.example.appkotlin.databinding.FragmentClassBinding
import com.example.appkotlin.databinding.FragmentWhenBinding

class ClassFragment : Fragment() {
    private lateinit var binding: FragmentClassBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentClassBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentClassBinding.inflate(layoutInflater)
        return  binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnVarVal.setOnClickListener {
            findNavController().navigate(R.id.action_classFragment_to_varValFragment)
        }
        binding.btnElseIf.setOnClickListener {
            findNavController().navigate(R.id.action_classFragment_to_elseIfFragment)
        }
        binding.btnNulls.setOnClickListener {
            findNavController().navigate(R.id.action_classFragment_to_nullsFragment)
        }
        binding.btnWhen.setOnClickListener {
            findNavController().navigate(R.id.action_classFragment_to_whenFragment)
        }
    }




}