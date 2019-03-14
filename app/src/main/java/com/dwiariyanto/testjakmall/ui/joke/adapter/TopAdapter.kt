package com.dwiariyanto.testjakmall.ui.joke.adapter

import android.support.v7.widget.RecyclerView
import com.dwiariyanto.recyclerview.adapter.BaseRecyclerViewAdapter
import com.dwiariyanto.recyclerview.extension.erViDecor
import com.dwiariyanto.recyclerview.extension.erViManager
import com.dwiariyanto.testjakmall.utils.dp

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

class TopAdapter(
    topTitleItem: TopTitleItem = TopTitleItem(),
    val topMoreItem: TopMoreItem = TopMoreItem(),
    val topContentItem: TopContentItem = TopContentItem()
) : BaseRecyclerViewAdapter(
    topTitleItem,
    topMoreItem,
    topContentItem
) {
    override fun build(recyclerView: RecyclerView) {
        recyclerView.apply {
            erViManager { }
            erViDecor {
                erViSpanSize = 16.dp
            }
        }
    }
}