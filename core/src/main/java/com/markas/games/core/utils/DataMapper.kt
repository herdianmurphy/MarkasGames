package com.markas.games.core.utils

import com.markas.games.core.data.source.local.entity.*
import com.markas.games.core.data.source.remote.response.GamesResponse
import com.markas.games.core.data.source.remote.response.GenresResponse
import com.markas.games.core.domain.model.Games
import com.markas.games.core.domain.model.Genres

object DataMapper {
    //PC GAMES
    fun mapPcResponsesToEntities(input: List<GamesResponse>): List<PcGamesEntity> {
        val gamesList = ArrayList<PcGamesEntity>()
        input.map {
            val games = PcGamesEntity(
                gamesId = it.id,
                slug = it.slug,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingCount,
                isFavorite = false
            )
            gamesList.add(games)
        }
        return gamesList
    }
    fun mapPcEntitiesToDomain(input: List<PcGamesEntity>): List<Games> =
        input.map {
            Games(
                id = it.gamesId,
                slug = it.slug,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                isFavorite = it.isFavorite
            )
        }
    fun mapPcDomainToEntity(input: Games) = PcGamesEntity(
        gamesId = input.id,
        slug = input.slug,
        name = input.name,
        released = input.released,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        isFavorite = input.isFavorite
    )

    //PS GAMES
    fun mapPsResponsesToEntities(input: List<GamesResponse>): List<PsGamesEntity> {
        val gamesList = ArrayList<PsGamesEntity>()
        input.map {
            val games = PsGamesEntity(
                gamesId = it.id,
                slug = it.slug,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingCount,
                isFavorite = false
            )
            gamesList.add(games)
        }
        return gamesList
    }
    fun mapPsEntitiesToDomain(input: List<PsGamesEntity>): List<Games> =
        input.map {
            Games(
                id = it.gamesId,
                slug = it.slug,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                isFavorite = it.isFavorite
            )
        }
    fun mapPsDomainToEntity(input: Games) = PsGamesEntity(
        gamesId = input.id,
        slug = input.slug,
        name = input.name,
        released = input.released,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        isFavorite = input.isFavorite
    )

    //XBOX GAMES
    fun mapXboxResponsesToEntities(input: List<GamesResponse>): List<XboxGamesEntity> {
        val gamesList = ArrayList<XboxGamesEntity>()
        input.map {
            val games = XboxGamesEntity(
                gamesId = it.id,
                slug = it.slug,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingCount,
                isFavorite = false
            )
            gamesList.add(games)
        }
        return gamesList
    }
    fun mapXboxEntitiesToDomain(input: List<XboxGamesEntity>): List<Games> =
        input.map {
            Games(
                id = it.gamesId,
                slug = it.slug,
                name = it.name,
                released = it.released,
                backgroundImage = it.backgroundImage,
                rating = it.rating,
                ratingsCount = it.ratingsCount,
                isFavorite = it.isFavorite
            )
        }
    fun mapXboxDomainToEntity(input: Games) = XboxGamesEntity(
        gamesId = input.id,
        slug = input.slug,
        name = input.name,
        released = input.released,
        backgroundImage = input.backgroundImage,
        rating = input.rating,
        ratingsCount = input.ratingsCount,
        isFavorite = input.isFavorite
    )

    //GENRES
    fun mapGenresResponsesToEntities(input: List<GenresResponse>): List<GenresEntity> {
        val genresList = ArrayList<GenresEntity>()
        input.map {
            val genres = GenresEntity(
                id = it.id,
                name = it.name,
                imageBackground = it.imageBackground
            )
            genresList.add(genres)
        }
        return genresList
    }

    fun mapGenresEntitiesToDomain(input: List<GenresEntity>): List<Genres> =
        input.map {
            Genres(
                id = it.id,
                name = it.name,
                imageBackground = it.imageBackground
            )
        }

    fun mapGenresDomainToEntity(input: Genres) = GenresEntity(
        id = input.id,
        name = input.name,
        imageBackground = input.imageBackground
    )
}