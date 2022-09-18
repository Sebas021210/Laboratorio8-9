package com.example.laboratorio8.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import coil.EventListener
import coil.load
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.laboratorio8.R
import com.example.laboratorio8.entities.Genero
import com.example.laboratorio8.entities.Place

class PlaceAdapter(private val dataSet: MutableList<Place>, private val listener: RecyclerPlaceClickHandler) : RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    class ViewHolder(private val view: View, private val listener: RecyclerPlaceClickHandler) : RecyclerView.ViewHolder(view) {
        private val imageType: ImageView = view.findViewById(R.id.imageCharacter)
        private val textName: TextView = view.findViewById(R.id.textNameCharacter)
        private val dataText: TextView = view.findViewById(R.id.textDataCharacter)
        private val layoutPlace: ConstraintLayout = view.findViewById(R.id.layout_itemPlace)

        fun setData(place: Place) {
            textName.text = place.name
            dataText.text = place.especie + " - " + place.status
            imageType.load(place.imagen) {
                crossfade(true)
                crossfade(2000)
                transformations(CircleCropTransformation())
                memoryCachePolicy(CachePolicy.DISABLED)
                diskCachePolicy(CachePolicy.DISABLED)
            }
            layoutPlace.setOnClickListener {
                listener.onPlaceClicked(place)
            }
        }
    }

    interface RecyclerPlaceClickHandler{
        fun onPlaceClicked(place: Place)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_place, parent, false)
        return ViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}