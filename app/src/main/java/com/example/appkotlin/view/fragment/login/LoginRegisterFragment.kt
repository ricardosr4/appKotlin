package com.example.appkotlin.view.fragment.login

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.appkotlin.R
import com.example.appkotlin.databinding.FragmentLoginRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class LoginRegisterFragment : Fragment() {
    private lateinit var binding: FragmentLoginRegisterBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentLoginRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //todo aqui se navega a FragmentLogin para iniciar secion
        binding.tvIrLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginRegisterFragment_to_loginFragment)
        }
        binding.btnRegister.setOnClickListener {

            if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString()
                    .isNotEmpty() && isValidEmail(binding.etEmail.text.toString())
            ) {

                registerUser(binding.etEmail.text.toString(), binding.etPassword.text.toString())

            } else {
                Toast.makeText(context, "por favor complete todos los campos", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun registerUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_loginRegisterFragment_to_loginFragment)
                    Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    // Registro exitoso, redirigir a la siguiente actividad o realizar otras acciones necesarias
                } else {
                    Toast.makeText(
                        context,
                        "Error al registrar: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    private fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }



}