package com.example.laboratorio8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView_mainActivity) as NavHostFragment

        navController = navHostFragment.navController

        val appbarConfig = AppBarConfiguration(navController.graph)
        toolbar = findViewById(R.id.toolbar_characters)
        toolbar.setupWithNavController(navController, appbarConfig)

        listenToNavGraphChanges()
    }

    private fun listenToNavGraphChanges() {
        navController.addOnDestinationChangedListener{_, destination,_ ->
            when (destination.id){
                R.id.charactersFragment ->{
                    toolbar.menu.findItem(R.id.AaZ).isVisible = true
                    toolbar.menu.findItem(R.id.ZaA).isVisible = true
                    toolbar.menu.findItem(R.id.CerrarSesion).isVisible = true
                }

                R.id.detailsFragment ->{
                    toolbar.menu.findItem(R.id.AaZ).isVisible = false
                    toolbar.menu.findItem(R.id.ZaA).isVisible = false
                    toolbar.menu.findItem(R.id.CerrarSesion).isVisible = false
                }

                R.id.sharedPreferencesFragment ->{
                    toolbar.menu.findItem(R.id.AaZ).isVisible = false
                    toolbar.menu.findItem(R.id.ZaA).isVisible = false
                    toolbar.menu.findItem(R.id.CerrarSesion).isVisible = false
                }
            }
        }
    }
}