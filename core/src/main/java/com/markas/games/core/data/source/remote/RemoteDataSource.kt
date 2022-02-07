package com.markas.games.core.data.source.remote

import android.util.Log
import com.markas.games.core.data.source.remote.network.ApiResponse
import com.markas.games.core.data.source.remote.network.ApiService
import com.markas.games.core.data.source.remote.response.GamesResponse
import com.markas.games.core.data.source.remote.response.GenresResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getPCGames(): Flow<ApiResponse<List<GamesResponse>>> {
        return flow {
            try {
                val response = apiService.getPCGames()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getPSGames(): Flow<ApiResponse<List<GamesResponse>>> {
        return flow {
            try {
                val response = apiService.getPSGames()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getXboxGames(): Flow<ApiResponse<List<GamesResponse>>> {
        return flow {
            try {
                val response = apiService.getXboxGames()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getListGenres(): Flow<ApiResponse<List<GenresResponse>>> {
        return flow {
            try {
                val response = apiService.getListGenres()
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}

