package com.dwiariyanto.testjakmall.ui.joke

import com.dwiariyanto.testjakmall.base.mvp.BaseLoadDataView

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

object TopContract {
    interface View : BaseLoadDataView<List<Any>>{
        fun showHelloDialog()
    }

    interface Presenter {
        fun loadRandomJoke()
        fun moveJokeToTopList(id:Int)
        fun selectJoke()
        fun addJoke()
    }
}