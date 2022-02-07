package com.markas.games.core.domain.repository

import com.markas.games.core.data.Resource
import com.markas.games.core.domain.model.Games
import com.markas.games.core.domain.model.Genres
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getPCGames(): Flow<Resource<List<Games>>>

    fun getPSGames(): Flow<Resource<List<Games>>>

    fun getXboxGames(): Flow<Resource<List<Games>>>

    fun getFavoritePcGames(): Flow<List<Games>>

    fun getFavoritePsGames(): Flow<List<Games>>

    fun getFavoriteXboxGames(): Flow<List<Games>>

    fun setFavoritePcGames(games: Games, state: Boolean)

    fun setFavoritePsGames(games: Games, state: Boolean)

    fun setFavoriteXboxGames(games: Games, state: Boolean)

    fun getListGenres(): Flow<Resource<List<Genres>>>
}