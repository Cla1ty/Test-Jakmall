package com.dwiariyanto.testjakmall.ui.joke

import com.dwiariyanto.testjakmall.base.mvp.BaseLoadDataView
import com.dwiariyanto.testjakmall.data.model.joke.JokeData

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

object JokeContract {
    interface View : BaseLoadDataView<List<JokeData>>{
        fun showHelloDialog()
    }

    interface Presenter {
        fun loadRandomJoke()
        fun moveJokeToTopList(jokeData: JokeData)
        fun selectJoke()
        fun addJoke()
    }
}