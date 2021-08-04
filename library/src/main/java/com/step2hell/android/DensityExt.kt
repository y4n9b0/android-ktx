package com.step2hell.android

import android.content.res.Resources
import kotlin.math.roundToInt

private val system = Resources.getSystem()
private val metrics = system.displayMetrics

val Float.dp2px
    get() = times(metrics.density).roundToInt()

val Float.sp2px
    get() = times(metrics.scaledDensity).roundToInt()

val Float.px2dp
    get() = div(metrics.density).roundToInt()

val Float.px2sp
    get() = div(metrics.scaledDensity).roundToInt()

val SCREEN_WIDTH: Int
    get() = metrics.widthPixels

val SCREEN_HEIGHT: Int
    get() = metrics.heightPixels

val STATUS_BAR_HEIGHT: Int
    get() {
        val resId = system.getIdentifier("status_bar_height", "dimen", "android")
        return if (resId != 0) system.getDimensionPixelSize(resId) else 24f.dp2px
    }
