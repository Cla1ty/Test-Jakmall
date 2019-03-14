package com.dwiariyanto.testjakmall.data.model.joke

import com.google.gson.annotations.SerializedName

data class JokeData(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("joke")
    val joke: String? = ""
)