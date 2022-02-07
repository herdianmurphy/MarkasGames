package com.markas.games.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGenresResponse(

    @field:SerializedName("results")
    val results: List<GenresResponse>
)