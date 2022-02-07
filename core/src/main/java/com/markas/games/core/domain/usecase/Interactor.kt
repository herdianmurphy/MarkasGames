package com.markas.games.core.domain.usecase

import com.markas.games.core.domain.model.Games
import com.markas.games.core.domain.repository.IRepository

class Interactor(private val repository: IRepository): UseCase {

    override fun getPCGames() = repository.getPCGames()

    override fun getPSGames() = repository.getPSGames()

    override fun getXboxGames() = repository.getXboxGames()

    override fun getFavoritePcGames() = repository.getFavoritePcGames()

    override fun getFavoritePsGames() = repository.getFavoritePsGames()

    override fun getFavoriteXboxGames() = repository.getFavoriteXboxGames()

    override fun setFavoritePcGames(games: Games, state: Boolean) = repository.setFavoritePcGames(games, state)

    override fun setFavoritePsGames(games: Games, state: Boolean) = repository.setFavoritePsGames(games, state)

    override fun setFavoriteXboxGames(games: Games, state: Boolean) = repository.setFavoriteXboxGames(games, state)

    override fun getListGenres() = repository.getListGenres()
}