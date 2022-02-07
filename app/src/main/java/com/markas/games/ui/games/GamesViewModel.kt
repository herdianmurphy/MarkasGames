package com.markas.games.ui.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.markas.games.core.domain.usecase.UseCase

class GamesViewModel(useCase: UseCase) : ViewModel() {
    val pcGames = useCase.getPCGames().asLiveData()
    val psGames = useCase.getPSGames().asLiveData()
    val xboxGames = useCase.getXboxGames().asLiveData()
}

