package com.dwiariyanto.testjakmall.ui.joke

import com.dwiariyanto.testjakmall.base.mvp.BaseLoadPresenter
import com.dwiariyanto.testjakmall.data.repository.JokeRepository
import com.dwiariyanto.testjakmall.ui.joke.adapter.TopMoreItem
import com.dwiariyanto.testjakmall.ui.joke.adapter.TopTitleItem

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

class TopPresenter(view: TopContract.View, private val jokeRepository: JokeRepository = JokeRepository.get) :
    BaseLoadPresenter<TopContract.View>(view), TopContract.Presenter {

    private var topJoke: TopJoke = TopJoke(emptyList())

    override fun loadRandomJoke() {
        asyncWithLoadingView(jokeRepository.getRandom()) {
            topJoke = TopJoke(it)
            view.showDataView(getListTopModel())
        }
    }

    override fun moveJokeToTopList(id: Int) {
        topJoke.moveToTop(id)
        view.showDataView(getListTopModel())
    }

    override fun selectJoke() {
        view.showHelloDialog()
    }

    override fun addJoke() {
        topJoke.addJoke()
        view.showDataView(getListTopModel())
    }

    private fun getListTopModel(): List<Any> =
        arrayListOf(TopTitleItem.Model())
            .plus(topJoke.getListTopModel())
            .let {
                if (topJoke.isReachLimit.not())
                    it.plus(TopMoreItem.Model())
                else
                    it
            }
}