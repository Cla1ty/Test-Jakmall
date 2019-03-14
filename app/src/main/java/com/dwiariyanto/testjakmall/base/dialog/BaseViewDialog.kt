package com.dwiariyanto.testjakmall.base.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.View
import com.dwiariyanto.testjakmall.widget.dialog.type.DialogInterface

/**
 * Created by Dwi Ariyanto on 4/5/18.
 */

abstract class BaseViewDialog(
    private val context: Context,
    private val view: View,
    private val cancelable: Boolean = false
) : DialogInterface {
    protected val dialog: AlertDialog = create()

    protected abstract fun onBindView(pLayout: View)

    init {
        dialogCreated()
    }

    private fun create()
            = AlertDialog.Builder(context)
            .apply {
                setView(view)
                setCancelable(cancelable)
            }
            .create()

    private fun dialogCreated(){
        onBindView(view)
    }

    override fun show() {
        dialog.show()
    }

    override fun dismiss() {
        dialog.dismiss()
    }
}