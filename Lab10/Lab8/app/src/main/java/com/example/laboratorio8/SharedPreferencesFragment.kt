package com.example.laboratorio8

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class SharedPreferencesFragment: Fragment(R.layout.shared_preferences_fragment) {

    private lateinit var buttonLogin: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin = view.findViewById(R.id.buttonIniciarSesion)

        setupListeners()
    }

    private fun setupListeners() {
        buttonLogin.setOnClickListener {
            requireView().findNavController().navigate(R.id.action_sharedPreferencesFragment_to_charactersFragment)
        }
    }
}