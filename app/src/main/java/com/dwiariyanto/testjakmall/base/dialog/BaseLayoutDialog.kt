package com.dwiariyanto.testjakmall.base.dialog

import android.content.Context
import android.view.LayoutInflater

/**
 * Created by Dwi Ariyanto on 4/5/18.
 */

abstract class BaseLayoutDialog(
    context: Context,
    layoutId: Int,
    cancelable: Boolean = false
) : BaseViewDialog(
    context,
    LayoutInflater.from(context).inflate(layoutId, null, false),
    cancelable
)