package com.dwiariyanto.testjakmall.widget.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.dwiariyanto.testjakmall.R
import com.dwiariyanto.testjakmall.utils.isVisible
import com.dwiariyanto.testjakmall.widget.view.`interface`.MessageViewInterface
import kotlinx.android.synthetic.main.view_empty.view.*

/**
 * Created by Dwi Ariyanto on 03/02/19.
 */
class EmptyView : RelativeLayout, MessageViewInterface {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_empty, this)
    }

    override fun setMessage(message: String?) {
        textMessage.text = message ?: context.getString(R.string.label_empty_result)
    }

    override fun visible() {
        isVisible = true
    }

    override fun gone() {
        isVisible = false
    }
}
