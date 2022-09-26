package com.example.laboratorio8

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.laboratorio8.datasource.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsFragment: Fragment(R.layout.details_fragment) {
    private lateinit var nameCharacterProfile: TextView
    private lateinit var specieCharacter: TextView
    private lateinit var statusCharacter: TextView
    private lateinit var genderCharacter: TextView
    private lateinit var imageCharacter: ImageView

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameCharacterProfile = view.findViewById(R.id.textNameProfile)
        specieCharacter = view.findViewById(R.id.textSpecietype)
        statusCharacter = view.findViewById(R.id.textStatusType)
        genderCharacter = view.findViewById(R.id.textGenderType)
        imageCharacter = view.findViewById(R.id.ImageCharacterProfile)

        nameCharacterProfile.text = args.place.name
        specieCharacter.text = args.place.especie
        statusCharacter.text = args.place.status.toString()
        genderCharacter.text = args.place.genero.toString()

        imageCharacter.load(args.place.imagen){
            crossfade(true)
            crossfade(2000)
            transformations(CircleCropTransformation())
            memoryCachePolicy(CachePolicy.ENABLED)
            diskCachePolicy(CachePolicy.ENABLED)
        }
    }
}