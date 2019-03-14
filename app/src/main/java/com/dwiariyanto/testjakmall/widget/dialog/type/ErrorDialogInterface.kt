package com.dwiariyanto.testjakmall.widget.dialog.type

import com.dwiariyanto.testjakmall.widget.dialog.type.DialogInterface

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
interface ErrorDialogInterface : DialogInterface {
    fun updateMessage(message: String)
}