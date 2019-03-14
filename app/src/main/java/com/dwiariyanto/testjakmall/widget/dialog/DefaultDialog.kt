package com.dwiariyanto.testjakmall.widget.dialog

import android.content.Context
import android.support.v7.app.AlertDialog
import com.dwiariyanto.testjakmall.widget.dialog.type.ErrorDialogInterface

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
class DefaultDialog(
    context: Context,
    title: String,
    message: String,
    buttonPositive: ButtonData? = null,
    buttonNegative: ButtonData? = null
) : ErrorDialogInterface {
    private val dialog by lazy {
        AlertDialog.Builder(context)
            .apply {
                setTitle(title)
                setMessage(message)
                buttonPositive?.let {
                    setPositiveButton(it.text) { dialog, _ ->
                        dialog.dismiss()
                        it.onClickAction.invoke()
                    }
                }
                buttonNegative?.let {
                    setPositiveButton(it.text) { dialog, _ ->
                        dialog.dismiss()
                        it.onClickAction.invoke()
                    }
                }
            }
            .create()
    }

    override fun updateMessage(message: String) {
        dialog.setMessage(message)
    }

    override fun show() {
        dialog.show()
    }

    override fun dismiss() {
        dialog.dismiss()
    }

    data class ButtonData(
        val text: String,
        val onClickAction: () -> Unit
    )
}