package com.durini.solucionlab10.datasource.util

import androidx.room.Database
import androidx.room.RoomDatabase
import com.durini.solucionlab10.datasource.model.Character
import com.durini.solucionlab10.datasource.model.CharacterStack

@Database(entities = [CharacterStack::class], version = 1)
abstract class Database: RoomDatabase() {

    abstract fun characterDato():CharacterDato

}