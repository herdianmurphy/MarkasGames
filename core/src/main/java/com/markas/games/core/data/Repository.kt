package com.markas.games.core.data

import com.markas.games.core.data.source.local.LocalDataSource
import com.markas.games.core.data.source.remote.RemoteDataSource
import com.markas.games.core.data.source.remote.network.ApiResponse
import com.markas.games.core.data.source.remote.response.GamesResponse
import com.markas.games.core.data.source.remote.response.GenresResponse
import com.markas.games.core.domain.model.Games
import com.markas.games.core.domain.model.Genres
import com.markas.games.core.domain.repository.IRepository
import com.markas.games.core.utils.AppExecutors
import com.markas.games.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IRepository {

    override fun getPCGames(): Flow<Resource<List<Games>>> =
        object : NetworkBoundResource<List<Games>, List<GamesResponse>>() {
            override fun loadFromDB(): Flow<List<Games>> {
                return localDataSource.getPcGames().map {
                    DataMapper.mapPcEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Games>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponse>>> =
                remoteDataSource.getPCGames()

            override suspend fun saveCallResult(data: List<GamesResponse>) {
                val gamesList = DataMapper.mapPcResponsesToEntities(data)
                localDataSource.insertPcGames(gamesList)
            }
        }.asFlow()
    override fun getPSGames(): Flow<Resource<List<Games>>> =
        object : NetworkBoundResource<List<Games>, List<GamesResponse>>() {
            override fun loadFromDB(): Flow<List<Games>> {
                return localDataSource.getPsGames().map {
                    DataMapper.mapPsEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Games>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponse>>> =
                remoteDataSource.getPSGames()

            override suspend fun saveCallResult(data: List<GamesResponse>) {
                val gamesList = DataMapper.mapPsResponsesToEntities(data)
                localDataSource.insertPsGames(gamesList)
            }
        }.asFlow()
    override fun getXboxGames(): Flow<Resource<List<Games>>> =
        object : NetworkBoundResource<List<Games>, List<GamesResponse>>() {
            override fun loadFromDB(): Flow<List<Games>> {
                return localDataSource.getXboxGames().map {
                    DataMapper.mapXboxEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Games>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponse>>> =
                remoteDataSource.getXboxGames()

            override suspend fun saveCallResult(data: List<GamesResponse>) {
                val gamesList = DataMapper.mapXboxResponsesToEntities(data)
                localDataSource.insertXboxGames(gamesList)
            }
        }.asFlow()

    override fun getFavoritePcGames(): Flow<List<Games>> {
        return localDataSource.getFavoritePcGames().map {
            DataMapper.mapPcEntitiesToDomain(it)
        }
    }
    override fun getFavoritePsGames(): Flow<List<Games>> {
        return localDataSource.getFavoritePsGames().map {
            DataMapper.mapPsEntitiesToDomain(it)
        }
    }
    override fun getFavoriteXboxGames(): Flow<List<Games>> {
        return localDataSource.getFavoriteXboxGames().map {
            DataMapper.mapXboxEntitiesToDomain(it)
        }
    }

    override fun setFavoritePcGames(games: Games, state: Boolean) {
        val pcGamesEntity = DataMapper.mapPcDomainToEntity(games)
        appExecutors.diskIO().execute { localDataSource.setFavoritePcGames(pcGamesEntity, state) }
    }
    override fun setFavoritePsGames(games: Games, state: Boolean) {
        val psGamesEntity = DataMapper.mapPsDomainToEntity(games)
        appExecutors.diskIO().execute { localDataSource.setFavoritePsGames(psGamesEntity, state) }
    }
    override fun setFavoriteXboxGames(games: Games, state: Boolean) {
        val xboxGamesEntity = DataMapper.mapXboxDomainToEntity(games)
        appExecutors.diskIO()
            .execute { localDataSource.setFavoriteXboxGames(xboxGamesEntity, state) }
    }

    override fun getListGenres(): Flow<Resource<List<Genres>>> =
        object : NetworkBoundResource<List<Genres>, List<GenresResponse>>() {
            override fun loadFromDB(): Flow<List<Genres>> {
                return localDataSource.getListGenres().map {
                    DataMapper.mapGenresEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Genres>?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<List<GenresResponse>>> =
                remoteDataSource.getListGenres()

            override suspend fun saveCallResult(data: List<GenresResponse>) {
                val genresList = DataMapper.mapGenresResponsesToEntities(data)
                localDataSource.insertGenres(genresList)
            }
        }.asFlow()
}

