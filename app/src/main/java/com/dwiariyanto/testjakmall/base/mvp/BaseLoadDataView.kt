package com.dwiariyanto.testjakmall.base.mvp

/**
 * Created by Dwi Ariyanto on 13/03/19.
 */

interface BaseLoadDataView<in DATA> : BaseLoadView {
    fun showDataView(data: DATA)
    fun hideDataView()
}