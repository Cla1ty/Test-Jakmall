package com.dwiariyanto.testjakmall.ui.joke

import android.os.Bundle
import android.view.View
import com.dwiariyanto.testjakmall.R
import com.dwiariyanto.testjakmall.base.activity.BaseActivity
import com.dwiariyanto.testjakmall.base.fragment.BaseMVPFragment
import com.dwiariyanto.testjakmall.factory.DialogFactory
import com.dwiariyanto.testjakmall.ui.joke.adapter.TopAdapter
import com.dwiariyanto.testjakmall.utils.gone
import com.dwiariyanto.testjakmall.utils.visible
import com.dwiariyanto.testjakmall.widget.dialog.DefaultDialog
import kotlinx.android.synthetic.main.global_load_view.*
import kotlinx.android.synthetic.main.top_fragment.*

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

class TopFragment : BaseMVPFragment<TopPresenter>(), TopContract.View {
    private val adapter = TopAdapter()

    override fun setup() = Setup(TAG, R.layout.top_fragment)
    override fun setupForToolbar() = SetupForToolbar(title = "Top Joke")
    override fun setupForLoadView() = LoadView.DefaultLoadView(context!!, loadingView, errorView)
    override fun createPresenter() = TopPresenter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initSwipeRefresh()
        initRecyclerView()

        presenter.loadRandomJoke()
    }

    private fun initRecyclerView() {
        recyclerView.adapter = adapter

        adapter.apply {
            topContentItem.listener.apply {
                onItemClickAction = {
                    presenter.selectJoke()
                }
                onMoveTopClickAction = { id ->
                    presenter.moveJokeToTopList(id)
                }
            }

            topMoreItem.listener.apply {
                onMoreClickAction = {
                    presenter.addJoke()
                }
            }
        }
    }

    private fun initSwipeRefresh() {
        swipeRefresh.setOnRefreshListener {
            presenter.loadRandomJoke()
        }
    }

    override fun showHelloDialog() {
        DialogFactory.create(
            context!!,
            DialogFactory.Type.DefaultDialogType(
                "Hello World", "",
                DefaultDialog.ButtonData("Hello too!"),
                DefaultDialog.ButtonData("Cancel")
            )
        ).show()
    }

    override fun showDataView(data: List<Any>) {
        recyclerView.visible()
        adapter.data = data
        swipeRefresh.isRefreshing = false
    }

    override fun hideDataView() {
        recyclerView.gone()
    }

    companion object {
        val TAG = TopFragment::class.java.name

        fun addFragment(baseActivity: BaseActivity) {
            baseActivity.addFragment(TopFragment())
        }
    }
}