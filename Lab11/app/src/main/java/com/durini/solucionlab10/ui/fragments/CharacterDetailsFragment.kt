package com.durini.solucionlab10.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.durini.solucionlab10.R
import com.durini.solucionlab10.datasource.api.RetrofitInstance
import com.durini.solucionlab10.datasource.model.Character
import com.durini.solucionlab10.datasource.model.CharacterStack
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDetailsFragment : Fragment(R.layout.fragment_character_details) {

    private val args: CharacterDetailsFragmentArgs by navArgs()
    private lateinit var txtName: TextInputLayout
    private lateinit var txtSpecies: TextInputLayout
    private lateinit var txtGender: TextInputLayout
    private lateinit var txtStatus: TextInputLayout
    private lateinit var txtOrigin: TextInputLayout
    private lateinit var txtEpisodes: TextInputLayout
    private lateinit var imageCharacter: ImageView
    private lateinit var buttonSave: Button
    private lateinit var toolbar: MaterialToolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.apply {
            txtName = findViewById(R.id.inputLayout_name)
            txtSpecies = findViewById(R.id.inputLayout_species)
            txtGender = findViewById(R.id.inputLayout_gender)
            txtStatus = findViewById(R.id.inputLayout_status)
            txtOrigin = findViewById(R.id.inputLayout_origin)
            txtEpisodes = findViewById(R.id.inputLayout_episodes)
            imageCharacter = findViewById(R.id.image_characterDetails)
            toolbar = findViewById(R.id.toolbar_characterDetails)
        }

        setToolbar()
        getCharacter()
        setListener()
    }

    private fun setListener() {
        buttonSave.setOnClickListener {
        }
    }

    private fun setToolbar() {
        val navController = findNavController()
        val appbarConfig = AppBarConfiguration(navController.graph)

        toolbar.setupWithNavController(navController, appbarConfig)
    }

    private fun getCharacter() {
        RetrofitInstance.api.getCharacter(args.id).enqueue(object: Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                if (response.isSuccessful && response.body() != null) {
                    var Char = response.body()!!
                    val miChar = CharacterStack(
                        id = Char.id,
                        name = Char.name,
                        status = Char.status,
                        species = Char.species,
                        gender = Char.gender,
                        image = Char.image,
                        origin = Char.origin.name.toString(),
                        episode = Char.episode.size
                    )
                    setData(miChar)
                }
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                Toast.makeText(requireContext(), getString(R.string.error_fetching), Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setData(character: CharacterStack) {
        character.apply {
            txtName.editText!!.setText(character.name)
            txtSpecies.editText!!.setText(character.species)
            txtStatus.editText!!.setText(character.status)
            txtGender.editText!!.setText(character.gender)
            txtOrigin.editText!!.setText(character.origin)
            txtEpisodes.editText!!.setText(character.episode.toString())
            imageCharacter.load(image) {
                placeholder(R.drawable.ic_downloading)
                transformations(CircleCropTransformation())
                error(R.drawable.ic_error)
                memoryCachePolicy(CachePolicy.ENABLED)
            }
        }
    }

}