package com.dwiariyanto.testjakmall.ui.joke.adapter

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.testjakmall.R
import kotlinx.android.synthetic.main.top_more_item.view.*

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
class TopMoreItem : BaseItemView<TopMoreItem.Model>(
    Model::class.java,
    R.layout.top_more_item
) {
    val listener = Listener()

    override fun onCreate(holder: RecyclerViewHolder) {
        holder.itemView.apply {
            btnAdd.setOnClickListener {
                listener.onMoreClickAction?.invoke()
            }
        }
    }

    data class Model(val id: Int = 0)

    data class Listener(
        var onMoreClickAction: (() -> Unit)? = null
    )
}