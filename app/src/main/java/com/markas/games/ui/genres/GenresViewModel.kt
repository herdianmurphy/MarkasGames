package com.markas.games.ui.genres

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.markas.games.core.domain.usecase.UseCase

class GenresViewModel(useCase: UseCase) : ViewModel() {
    val genresList = useCase.getListGenres().asLiveData()
}

