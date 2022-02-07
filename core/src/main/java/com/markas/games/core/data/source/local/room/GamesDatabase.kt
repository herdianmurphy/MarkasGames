package com.markas.games.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.markas.games.core.data.source.local.entity.*

@Database(entities = [
    GenresEntity::class,
    PcGamesEntity::class,
    PsGamesEntity::class,
    XboxGamesEntity::class], version = 1, exportSchema = false
)
abstract class GamesDatabase : RoomDatabase() {

    abstract fun gamesDao(): GamesDao
}