package com.dwiariyanto.testjakmall.widget.dialog

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ProgressBar
import com.dwiariyanto.testjakmall.base.dialog.BaseViewDialog

/**
 * Created by Dwi Ariyanto on 4/14/18.
 */

class LoadingDialog(context: Context) : BaseViewDialog(
    context, ProgressBar(context), false
) {
    override fun onBindView(pLayout: View) {
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
