package com.durini.solucionlab10.datasource.util

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.durini.solucionlab10.datasource.model.CharacterStack

@Dao
interface CharacterDato {

    @Query("SELECT * FROM CharacterStack")
    suspend fun getAllCharacters(): List<CharacterStack>

    @Query("SELECT * FROM CharacterStack WHERE id = :id")
    suspend fun getCharacter(id: Int): CharacterStack

    @Update
    suspend fun update(characterStack: CharacterStack)

    @Delete
    suspend fun deleteCharacters(characterStack: CharacterStack)

}