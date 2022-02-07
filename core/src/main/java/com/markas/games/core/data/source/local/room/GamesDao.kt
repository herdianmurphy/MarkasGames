package com.markas.games.core.data.source.local.room

import androidx.room.*
import com.markas.games.core.data.source.local.entity.GenresEntity
import com.markas.games.core.data.source.local.entity.PcGamesEntity
import com.markas.games.core.data.source.local.entity.PsGamesEntity
import com.markas.games.core.data.source.local.entity.XboxGamesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GamesDao {

    @Query("SELECT * FROM pc_games")
    fun getPcGames(): Flow<List<PcGamesEntity>>

    @Query("SELECT * FROM ps_games")
    fun getPsGames(): Flow<List<PsGamesEntity>>

    @Query("SELECT * FROM xbox_games")
    fun getXboxGames(): Flow<List<XboxGamesEntity>>

    @Query("SELECT * FROM pc_games where isFavorite = 1")
    fun getFavoritePcGames(): Flow<List<PcGamesEntity>>

    @Query("SELECT * FROM ps_games where isFavorite = 1")
    fun getFavoritePsGames(): Flow<List<PsGamesEntity>>

    @Query("SELECT * FROM xbox_games where isFavorite = 1")
    fun getFavoriteXboxGames(): Flow<List<XboxGamesEntity>>

    @Query("SELECT * FROM genres")
    fun getListGenres(): Flow<List<GenresEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPcGames(pcGames: List<PcGamesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPsGames(psGames: List<PsGamesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertXboxGames(xboxGames: List<XboxGamesEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGenres(genres: List<GenresEntity>)

    @Update
    fun updateFavoritePcGames(pcGames: PcGamesEntity)

    @Update
    fun updateFavoritePsGames(psGames: PsGamesEntity)

    @Update
    fun updateFavoriteXboxGames(xboxGames: XboxGamesEntity)
}
