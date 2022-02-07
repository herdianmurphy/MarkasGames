package com.markas.games.core.data.source.remote.network

import com.markas.games.core.data.source.remote.response.ListGamesResponse
import com.markas.games.core.data.source.remote.response.ListGenresResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    private val apiKey: String get() = "7cd6427f8b464129bbdccbedf7f57c5c"

    @GET("games")
    suspend fun getPCGames(
        @Query("key") key: String = apiKey,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 10,
        @Query("platforms") platforms: Int = 4
    ): ListGamesResponse

    @GET("games")
    suspend fun getPSGames(
        @Query("key") key: String = apiKey,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 10,
        @Query("platforms") platforms: Int = 187
    ): ListGamesResponse

    @GET("games")
    suspend fun getXboxGames(
        @Query("key") key: String = apiKey,
        @Query("page") page: Int = 1,
        @Query("page_size") pageSize: Int = 10,
        @Query("platforms") platforms: Int = 4
    ): ListGamesResponse

    @GET("genres")
    suspend fun getListGenres(
        @Query("key") key: String = apiKey
    ): ListGenresResponse
}
