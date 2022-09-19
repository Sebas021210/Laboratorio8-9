package com.example.laboratorio8.DataBase

import com.example.laboratorio8.entities.Estatus
import com.example.laboratorio8.entities.Genero
import com.example.laboratorio8.entities.Place

object Database {
    private val places = mutableListOf(
        Place (name = "Bootleg Portal Chemist Rick", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/56.jpeg"),
        Place (name = "Steve Jobs Rick", especie = "Human", status = Estatus.VIVO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/483.jpeg"),
        Place (name = "Robot Rick", especie = "Robot", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/299.jpeg"),
        Place (name = "Josh", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/609.jpeg"),
        Place (name = "Morty´s Mother-in-law", especie = "Human", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/660.jpeg"),
        Place (name = "Rick Sanchez", especie = "Human", status = Estatus.VIVO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        Place (name = "Morty Smith", especie = "Human", status = Estatus.VIVO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/2.jpeg"),
        Place (name = "Beth Sanchez", especie = "Human", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/37.jpeg"),
        Place (name = "Unmuscular Michael", especie = "Human", status = Estatus.VIVO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/373.jpeg"),
        Place (name = "Cop Morty", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/73.jpeg"),
        Place (name = "Cirque du Soleil Zumanity Member", especie = "Human", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/737.jpeg"),
        Place (name = "Gotron Pilot", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/777.jpeg"),
        Place (name = "Stair Goblin", especie = "Mythological Creature", status = Estatus.VIVO, genero = Genero.DESCONOCIDO, imagen = "https://rickandmortyapi.com/api/character/avatar/333.jpeg"),
        Place (name = "Alan Rails", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/10.jpeg"),
        Place (name = "Albert Einstein", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/11.jpeg"),
        Place (name = "Alexander", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/12.jpeg"),
        Place (name = "Summer Smith", especie = "Human", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/3.jpeg"),
        Place (name = "Beth Smith", especie = "Human", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/4.jpeg"),
        Place (name = "Jerry Smith", especie = "Human", status = Estatus.VIVO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/5.jpeg"),
        Place (name = "Abadango Cluster Princess", especie = "Alien", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/6.jpeg"),
        Place (name = "Abradolf Lincler", especie = "Human", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/7.jpeg"),
        Place (name = "Adjudicator Rick", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/8.jpeg"),
        Place (name = "Agency Director", especie = "Human", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/9.jpeg"),
        Place (name = "Alien Googah", especie = "Alien", status = Estatus.UNKNOWN, genero = Genero.DESCONOCIDO, imagen = "https://rickandmortyapi.com/api/character/avatar/13.jpeg"),
        Place (name = "Alien Morty", especie = "Alien", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/14.jpeg"),
        Place (name = "Alien Rick", especie = "Alien", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/15.jpeg"),
        Place (name = "Amish Cyborg", especie = "Alien", status = Estatus.MUERTO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/16.jpeg"),
        Place (name = "Annie", especie = "Human", status = Estatus.VIVO, genero = Genero.FEMENINO, imagen = "https://rickandmortyapi.com/api/character/avatar/17.jpeg"),
        Place (name = "Antenna Morty", especie = "Human", status = Estatus.VIVO, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/18.jpeg"),
        Place (name = "Antenna Rick", especie = "Human", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/19.jpeg"),
        Place (name = "Ants in my Eyes Johnson", especie = "Human", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/20.jpeg"),
        Place (name = "Aqua Morty", especie = "Humanoid", status = Estatus.UNKNOWN, genero = Genero.MASCULINO, imagen = "https://rickandmortyapi.com/api/character/avatar/21.jpeg")
    )

    fun getPlaces() = places
}