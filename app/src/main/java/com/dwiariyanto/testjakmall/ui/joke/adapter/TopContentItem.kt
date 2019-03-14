package com.dwiariyanto.testjakmall.ui.joke.adapter

import com.dwiariyanto.recyclerview.adapter.BaseItemView
import com.dwiariyanto.recyclerview.adapter.RecyclerViewHolder
import com.dwiariyanto.testjakmall.R
import com.dwiariyanto.testjakmall.utils.isVisible
import kotlinx.android.synthetic.main.top_content_item.view.*

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
class TopContentItem : BaseItemView<TopContentItem.Model>(
    Model::class.java,
    R.layout.top_content_item
) {
    val listener: Listener = Listener()

    override fun onBind(holder: RecyclerViewHolder, data: Model) {
        holder.itemView.apply {
            tvContent.text = data.content
            tvTop.isVisible = data.isTop
            ivMoveTop.isVisible = data.isTop.not()

            setOnClickListener {
                listener.onItemClickAction?.invoke()
            }

            ivMoveTop.setOnClickListener {
                listener.onMoveTopClickAction?.invoke(data.id)
            }
        }
    }

    data class Model(
        val id: Int,
        val content: String,
        var isTop: Boolean
    )

    data class Listener(
        var onItemClickAction: (() -> Unit)? = null,
        var onMoveTopClickAction: ((id: Int) -> Unit)? = null
    )
}