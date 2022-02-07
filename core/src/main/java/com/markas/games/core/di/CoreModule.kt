package com.markas.games.core.di

import androidx.room.Room
import com.markas.games.core.data.Repository
import com.markas.games.core.data.source.local.LocalDataSource
import com.markas.games.core.data.source.local.room.GamesDatabase
import com.markas.games.core.data.source.remote.RemoteDataSource
import com.markas.games.core.data.source.remote.network.ApiService
import com.markas.games.core.domain.repository.IRepository
import com.markas.games.core.utils.AppExecutors
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<GamesDatabase>().gamesDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            GamesDatabase::class.java, "Games.db"
        ).fallbackToDestructiveMigration().build()
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IRepository> {
        Repository(
            get(),
            get(),
            get()
        )
    }
}