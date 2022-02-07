package com.markas.games.di

import com.markas.games.core.domain.usecase.Interactor
import com.markas.games.core.domain.usecase.UseCase
import com.markas.games.ui.detail.DetailGamesViewModel
import com.markas.games.ui.games.GamesViewModel
import com.markas.games.ui.genres.GenresViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<UseCase> { Interactor(get()) }
}

val viewModelModule = module {
    viewModel { GamesViewModel(get()) }
    viewModel { DetailGamesViewModel(get()) }
    viewModel { GenresViewModel(get()) }
}