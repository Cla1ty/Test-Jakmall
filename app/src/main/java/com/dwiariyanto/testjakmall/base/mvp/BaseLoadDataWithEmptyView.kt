package com.dwiariyanto.testjakmall.base.mvp

/**
 * Created by Dwi Ariyanto on 13/03/19.
 */
interface BaseLoadDataWithEmptyView<in DATA> : BaseLoadDataView<DATA> {
    fun showEmptyDataView()
    fun hideEmptyDataView()
}