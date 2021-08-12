package com.step2hell.android

import android.content.res.Resources
import kotlin.math.roundToInt

private val system = Resources.getSystem()
private val metrics = system.displayMetrics

val Number.dp2px
    get() = toFloat().times(metrics.density).roundToInt()

val Number.sp2px
    get() = toFloat().times(metrics.scaledDensity).roundToInt()

val Number.px2dp
    get() = toFloat().div(metrics.density).roundToInt()

val Number.px2sp
    get() = toFloat().div(metrics.scaledDensity).roundToInt()

val SCREEN_WIDTH: Int
    get() = metrics.widthPixels

val SCREEN_HEIGHT: Int
    get() = metrics.heightPixels

val STATUS_BAR_HEIGHT: Int
    get() {
        val resId = system.getIdentifier("status_bar_height", "dimen", "android")
        return if (resId != 0) system.getDimensionPixelSize(resId) else 24f.dp2px
    }
