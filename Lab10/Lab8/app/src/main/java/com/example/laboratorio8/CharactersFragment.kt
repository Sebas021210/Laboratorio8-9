package com.example.laboratorio8

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio8.DataBase.Database
import com.example.laboratorio8.adapters.PlaceAdapter
import com.example.laboratorio8.datasource.api.RetrofitInstance
import com.example.laboratorio8.datasource.model.Character
import com.example.laboratorio8.datasource.model.CharactersResponse
import com.example.laboratorio8.entities.Place
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersFragment: Fragment(R.layout.characters_fragment), PlaceAdapter.RecyclerPlaceClickHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var placeList: MutableList<Place>
    private lateinit var botonAZ: Button
    private lateinit var botonZA:Button
    private lateinit var adapter: PlaceAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_characters)
        botonAZ = view.findViewById(R.id.buttonAZ)
        botonZA = view.findViewById(R.id.buttonZA)

        setupRecycler()
        setupListeners()
    }

    private fun setupListeners() {
        botonAZ.setOnClickListener {
            placeList.sortBy { place -> place.name }
            adapter.notifyDataSetChanged()
        }
        botonZA.setOnClickListener {
            placeList.sortByDescending { place -> place.name }
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupRecycler() {
        placeList = Database.getPlaces()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.setHasFixedSize(true)
        adapter = PlaceAdapter(placeList, this)
        recyclerView.adapter = adapter
    }


    override fun onPlaceClicked(place: Place) {
        val action = CharactersFragmentDirections.actionCharactersFragmentToDetailsFragment(
            place
        )
        requireView().findNavController().navigate(action)
    }
}