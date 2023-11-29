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
import com.example.appkotlin.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

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
        binding.btnEnter.setOnClickListener {
            if (binding.etUser.text.toString().isNotEmpty() && binding.etPassword.text.toString()
                    .isNotEmpty() && isValidEmail(binding.etUser.text.toString())
            ) {
                enterUser(binding.etUser.text.toString(), binding.etPassword.text.toString())

            } else {
                Toast.makeText(context, "por favor complete todos los campos", Toast.LENGTH_SHORT)
                    .show()
            }

        }
        //todo aqui navega a fragmentLoginRegister para crear una cuenta
        binding.tvCreateUser.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_loginRegisterFragment)
        }

    }

    private fun enterUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener() { task ->
                if (task.isSuccessful) {
                    findNavController().navigate(R.id.action_loginFragment_to_classFragment)

                } else {
                    Toast.makeText(
                        context,
                        "Error al registrar: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

    //todo esta funcion sirve para validar que sea un correo electronico valido.
    private fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

}




