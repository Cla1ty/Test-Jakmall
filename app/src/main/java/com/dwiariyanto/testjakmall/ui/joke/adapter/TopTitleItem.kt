package com.dwiariyanto.testjakmall.ui.joke.adapter

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.testjakmall.R
import kotlinx.android.synthetic.main.top_title_item.view.*

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
class TopTitleItem : BaseItemView<TopTitleItem.Model>(
    Model::class.java,
    R.layout.top_title_item
) {
    override fun onBind(holder: RecyclerViewHolder, data: Model) {
        holder.itemView.apply {
            tvTitle.text = data.title
        }
    }

    data class Model(val title: String = "Who's on Top?")
}