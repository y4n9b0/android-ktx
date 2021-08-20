package com.step2hell.android

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

@Deprecated(
    "Cannot avoid passing argument Looper!",
    replaceWith = ReplaceWith("Extended function LifecycleOwner#lifecycleHandler(Looper)"),
    level = DeprecationLevel.HIDDEN
)
val lifecycleHandler: LifecycleOwner.(Looper) -> Handler = { looper ->
    LifecycleHandler(this, looper)
}

fun LifecycleOwner.lifecycleHandler(looper: Looper = Looper.getMainLooper()): Handler = LifecycleHandler(this, looper)

private class LifecycleHandler(
    private val owner: LifecycleOwner,
    looper: Looper = Looper.getMainLooper()
) : Handler(looper), LifecycleObserver {
    init {
        owner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun onDestroy() {
        owner.lifecycle.removeObserver(this)
        removeCallbacksAndMessages(null)
    }
}
