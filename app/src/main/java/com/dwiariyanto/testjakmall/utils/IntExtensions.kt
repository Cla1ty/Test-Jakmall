package com.dwiariyanto.testjakmall.utils

val Int.dp: Int
    get() = MathHelper.dp2Px(toFloat()).toInt()
