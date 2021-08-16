package com.step2hell.android

import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.annotation.IntDef
import androidx.annotation.StringRes

@IntDef(value = [Toast.LENGTH_SHORT, Toast.LENGTH_LONG])
@Retention(AnnotationRetention.SOURCE)
internal annotation class Duration

@Throws(Resources.NotFoundException::class)
fun Context.toast(@StringRes resId: Int, @Duration duration: Int = Toast.LENGTH_SHORT): Context = apply {
    Toast.makeText(this, resId, duration).show()
}

fun Context.toast(text: CharSequence, @Duration duration: Int = Toast.LENGTH_SHORT): Context = apply {
    Toast.makeText(this, text, duration).show()
}
