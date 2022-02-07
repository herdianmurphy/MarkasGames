package com.markas.games.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.markas.games.core.domain.usecase.UseCase

class FavoriteViewModel (useCase: UseCase) : ViewModel() {
    val favoritePc = useCase.getFavoritePcGames().asLiveData()
    val favoritePs = useCase.getFavoritePsGames().asLiveData()
    val favoriteXbox = useCase.getFavoriteXboxGames().asLiveData()
}