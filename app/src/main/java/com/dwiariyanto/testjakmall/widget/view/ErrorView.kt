package com.dwiariyanto.testjakmall.widget.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.dwiariyanto.testjakmall.R
import com.dwiariyanto.testjakmall.utils.isVisible
import com.dwiariyanto.testjakmall.widget.view.`interface`.MessageViewInterface
import kotlinx.android.synthetic.main.view_error.view.*

/**
 * Created by Dwi Ariyanto on 03/02/19.
 */
class ErrorView : RelativeLayout, MessageViewInterface {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context).inflate(R.layout.view_error, this)
    }

    fun onTryAgainClickListener(onTryAgainClick: (() -> Unit)) {
        buttonTryAgain.setOnClickListener { onTryAgainClick.invoke() }
    }


    override fun setMessage(message: String?) {
        textMessage.text = message ?: context.getString(R.string.label_error_result)
    }

    override fun visible() {
        isVisible = true
    }

    override fun gone() {
        isVisible = false
    }
}
