package com.dwiariyanto.testjakmall

import android.app.Application
import com.dwiariyanto.testjakmall.utils.MathHelper

/**
 * Created by Dwi Ariyanto on 14/03/19.
 */

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        MathHelper.install(this)
    }
}