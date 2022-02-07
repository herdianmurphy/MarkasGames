package com.markas.games

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.markas.games.core.di.databaseModule
import com.markas.games.core.di.networkModule
import com.markas.games.core.di.repositoryModule
import com.markas.games.di.useCaseModule
import com.markas.games.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}