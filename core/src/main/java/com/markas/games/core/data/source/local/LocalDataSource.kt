package com.markas.games.core.data.source.local

import com.markas.games.core.data.source.local.entity.*
import com.markas.games.core.data.source.local.room.GamesDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val gamesDao: GamesDao) {

    fun getPcGames(): Flow<List<PcGamesEntity>> = gamesDao.getPcGames()

    fun getPsGames(): Flow<List<PsGamesEntity>> = gamesDao.getPsGames()

    fun getXboxGames(): Flow<List<XboxGamesEntity>> = gamesDao.getXboxGames()

    fun getFavoritePcGames(): Flow<List<PcGamesEntity>> = gamesDao.getFavoritePcGames()

    fun getFavoritePsGames(): Flow<List<PsGamesEntity>> = gamesDao.getFavoritePsGames()

    fun getFavoriteXboxGames(): Flow<List<XboxGamesEntity>> = gamesDao.getFavoriteXboxGames()

    fun getListGenres(): Flow<List<GenresEntity>> = gamesDao.getListGenres()

    suspend fun insertPcGames(pcGamesList: List<PcGamesEntity>) = gamesDao.insertPcGames(pcGamesList)

    suspend fun insertPsGames(psGamesList: List<PsGamesEntity>) = gamesDao.insertPsGames(psGamesList)

    suspend fun insertXboxGames(xboxGamesList: List<XboxGamesEntity>) = gamesDao.insertXboxGames(xboxGamesList)

    suspend fun insertGenres(genresList: List<GenresEntity>) = gamesDao.insertGenres(genresList)

    fun setFavoritePcGames(pcGames: PcGamesEntity, newState: Boolean) {
        pcGames.isFavorite = newState
        gamesDao.updateFavoritePcGames(pcGames)
    }

    fun setFavoritePsGames(psGames: PsGamesEntity, newState: Boolean) {
        psGames.isFavorite = newState
        gamesDao.updateFavoritePsGames(psGames)
    }

    fun setFavoriteXboxGames(xboxGames: XboxGamesEntity, newState: Boolean) {
        xboxGames.isFavorite = newState
        gamesDao.updateFavoriteXboxGames(xboxGames)
    }
}