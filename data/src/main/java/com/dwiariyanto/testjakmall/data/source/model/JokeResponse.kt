package com.dwiariyanto.testjakmall.data.source.model

import com.dwiariyanto.testjakmall.data.model.joke.JokeData
import com.google.gson.annotations.SerializedName

data class JokeResponse(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("value")
    val value: List<JokeData>? = emptyList()
)