package com.markas.games.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenresResponse(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("image_background")
    val imageBackground: String,
)

