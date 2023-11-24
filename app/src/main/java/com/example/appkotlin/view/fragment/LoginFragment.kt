package com.example.appkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.appkotlin.R
import com.example.appkotlin.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val userPassword = "12345"


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//todo aqui se llama a la funcion al hacer click en el boton enter
        binding.btnEnter.setOnClickListener { navigateToClass() }

    }
    //todo funcion para pasar al fragmentToClass
     private fun navigateToClass() {

//todo aqui llegan los valores de la caja de texto
        val name = binding.etUser.text.toString()
        val password = binding.etPassword.text.toString()

//todo aqui se valida el nombre y su contraseña para pasar al siguiente fragment
        if (name.isNotEmpty() && password == userPassword){
            findNavController().navigate(R.id.action_loginFragment_to_classFragment)

        }else{
            Toast.makeText(context, "Usuario o Contraseña Incorrecta", Toast.LENGTH_SHORT).show()
        }

    }
}




