package com.dwiariyanto.testjakmall.utils

import android.view.View

/**
 * Created by Dwi Ariyanto on 13/03/19.
 */

var View.isVisible
    get() = visibility == View.VISIBLE
    set(value) {
        if (value)
            visibility = View.VISIBLE
        else
            visibility = View.GONE
    }

fun View.visible() {
    isVisible = true
}

fun View.gone() {
    isVisible = false
}