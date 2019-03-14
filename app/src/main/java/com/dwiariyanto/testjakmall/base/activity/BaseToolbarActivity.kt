package com.dwiariyanto.testjakmall.base.activity

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View

/**
 * Created by dwi.ariyanto on 1/25/2018.
 */

abstract class BaseToolbarActivity : BaseActivity()
{
    var isUseDefaultToolbar = false

    abstract fun toolbar(): Toolbar?

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        setupToolbar(null)
    }

    fun setupToolbar(customToolbar: Toolbar?)
    {
        if (customToolbar == null && isUseDefaultToolbar) return

        val useToolbar = if (customToolbar != null)
        {
            isUseDefaultToolbar = false
            toolbar()?.visibility = View.GONE
            customToolbar
        }
        else
        {
            isUseDefaultToolbar = true
            toolbar()?.visibility = View.VISIBLE
            toolbar()
        }

        useToolbar?.also {
            setSupportActionBar(it)
            supportActionBar?.apply {
                setDisplayShowHomeEnabled(true)
                setDisplayHomeAsUpEnabled(true)
                setDisplayShowCustomEnabled(true)
            }
        }
    }
}