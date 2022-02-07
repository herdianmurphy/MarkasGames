package com.markas.games.ui.detail

import androidx.lifecycle.ViewModel
import com.markas.games.core.domain.model.Games
import com.markas.games.core.domain.usecase.UseCase

class DetailGamesViewModel(private val useCase: UseCase) : ViewModel() {
    fun setFavoritePcGames(games: Games, newStatus:Boolean) =
        useCase.setFavoritePcGames(games, newStatus)

    fun setFavoritePsGames(games: Games, newStatus:Boolean) =
        useCase.setFavoritePsGames(games, newStatus)

    fun setFavoriteXboxGames(games: Games, newStatus:Boolean) =
        useCase.setFavoriteXboxGames(games, newStatus)
}

