package com.dwiariyanto.testjakmall.utils

import android.app.Application
import android.content.Context
import android.util.DisplayMetrics
import android.util.TypedValue
import org.jetbrains.annotations.TestOnly
import java.util.*
import kotlin.collections.ArrayList

/**
* Created by Dwi Ariyanto (creatures99@gmail.com)
* on Tuesday, October 17, 2017
*/

object MathHelper {
    private val random = Random()
    private lateinit var matrics: DisplayMetrics

    fun install(app: Application) {
        matrics = app.applicationContext.resources.displayMetrics
    }

    @TestOnly
    fun install(context: Context) {
        matrics = context.applicationContext.resources.displayMetrics
    }

    // random termasuk min dan max
    fun random(min: Float, max: Float): Float = (max - min) * random.nextFloat() + min

    // random termasuk min dan max
    fun random(min: Int, max: Int): Int = random.nextInt(max - min + 1) + min

    // benar" random, tidak akan menghasilkan list yang sama
    fun <T> random(list: List<T>): List<T> {
        if (list.size < 2)
            return list

        val indexes = ArrayList<Int>()
        val copy = ArrayList<T>()

        do {
            indexes += 0 until list.size
            copy.clear()

            var same = true
            for (i in 0 until list.size) {
                val index = random(0, indexes.size - 1)

                if (i != indexes[index])
                    same = false

                copy.add(list[indexes[index]])
                indexes.removeAt(index)
            }
        } while (same)

        return copy
    }

    fun dp2Px(dp: Float): Float =
            TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    dp,
                    matrics
            )

    fun px2Sp(px: Float): Float = px / matrics.scaledDensity

    fun sp2Px(sp: Float): Float =
            TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_SP,
                    sp,
                    matrics
            )
}
