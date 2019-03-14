package com.dwiariyanto.testjakmall.ui.joke

import com.dwiariyanto.testjakmall.data.model.joke.JokeData
import com.dwiariyanto.testjakmall.ui.joke.adapter.TopContentItem

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
class TopJoke(
    private val initJokeData: List<JokeData>
) {
    private val DEFAULT_LIMIT = 3
    private val MAX_LIMIT = 5

    private var currentLimit = DEFAULT_LIMIT

    private var listTopModel: List<TopContentItem.Model>

    val isReachLimit: Boolean
        get() = currentLimit == MAX_LIMIT

    init {
        listTopModel = initJokeData.take(currentLimit).map { mapToTopModel(it) }
        if (listTopModel.isNotEmpty())
            listTopModel[0].isTop = true
    }

    fun getListTopModel() = listTopModel

    fun moveToTop(id: Int) {
        val newListTopData = listTopModel.filter { it.id != id }.map { it.copy(isTop = false) }
        val jokeData = initJokeData.find { it.id == id } ?: JokeData()
        val newTopModel = mapToTopModel(jokeData, true)
        listTopModel = arrayListOf(newTopModel).plus(newListTopData)
    }

    fun addJoke() {
        if (isReachLimit) return

        currentLimit++
        val jokeData = initJokeData[currentLimit]
        val newTopModel = mapToTopModel(jokeData)
        listTopModel = listTopModel.plus(newTopModel)
    }

    private fun mapToTopModel(jokeData: JokeData, isTop: Boolean = false) =
        TopContentItem.Model(jokeData.id ?: 0, jokeData.joke ?: "", isTop)
}

