package com.dwiariyanto.testjakmall.ui.joke

import android.os.Bundle
import com.dwiariyanto.testjakmall.R
import com.dwiariyanto.testjakmall.base.activity.BaseToolbarActivity
import kotlinx.android.synthetic.main.global_activity_with_toolbar.*

class TopActivity : BaseToolbarActivity() {
    override fun setup() = Setup(TAG, R.layout.global_activity_with_toolbar, R.id.content)
    override fun toolbar() = toolbar!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TopFragment.addFragment(this)
    }

    companion object {
        val TAG = TopActivity::class.java.name
    }
}
