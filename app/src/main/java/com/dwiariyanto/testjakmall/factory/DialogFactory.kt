package com.dwiariyanto.testjakmall.factory

import android.content.Context
import com.dwiariyanto.testjakmall.widget.dialog.DefaultDialog
import com.dwiariyanto.testjakmall.widget.dialog.LoadingDialog
import com.dwiariyanto.testjakmall.widget.dialog.type.DialogInterface
import com.dwiariyanto.testjakmall.R


/**
 * Created by Dwi Ariyanto on 14/03/19.
 */
object DialogFactory {
    fun create(context: Context, type: Type): DialogInterface {
        return when (type) {
            is Type.LoadingDialogType -> createLoadingDialog(context)
            is Type.ErrorDialogType -> createErrorDialog(context, type)
            is Type.SimpleDialogType -> createSimpleDialog(context, type)
            is Type.DefaultDialogType -> createDefaultDialog(context, type)
        }
    }

    private fun createDefaultDialog(context: Context, type: Type.DefaultDialogType) =
        DefaultDialog(context, type.title, type.message, type.buttonPositive, type.buttonNegative)

    private fun createLoadingDialog(context: Context) =
        LoadingDialog(context)

    private fun createErrorDialog(context: Context, type: Type.ErrorDialogType) =
        DefaultDialog(
            context,
            context.getString(R.string.error),
            type.message,
            DefaultDialog.ButtonData(context.getString(android.R.string.ok)) {}
        )

    private fun createSimpleDialog(context: Context, type: Type.SimpleDialogType) =
        DefaultDialog(
            context,
            type.title,
            type.message,
            DefaultDialog.ButtonData(context.getString(android.R.string.ok)) {}
        )

    sealed class Type {
        class LoadingDialogType : Type()

        class SimpleDialogType(
            val title: String,
            val message: String
        ) : Type()

        class ErrorDialogType(
            val message: String
        ) : Type()

        class DefaultDialogType(
            val title: String,
            val message: String,
            val buttonPositive: DefaultDialog.ButtonData? = null,
            val buttonNegative: DefaultDialog.ButtonData? = null
        ) : Type()
    }
}
