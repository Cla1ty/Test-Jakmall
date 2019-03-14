package com.dwiariyanto.testjakmall.base.mvp

/**
 * Created by Dwi Ariyanto on 13/03/19.
 */

interface BaseLoadView : BaseView {
    fun showLoadingDialog()
    fun hideLoadingDialog()
    fun showErrorDialog(message: String)
    fun hideErrorDialog()

    fun showLoadingView()
    fun hideLoadingView()
    fun showErrorView(message: String)
    fun hideErrorView()
}