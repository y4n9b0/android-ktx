package com.step2hell.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

inline fun <T> CoroutineScope.launch(
    context: CoroutineContext = CoroutineExceptionHandler { _, throwable -> onFailure(throwable) },
    start: CoroutineStart = CoroutineStart.DEFAULT,
    crossinline action: suspend () -> Result<T>,
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit = {},
    crossinline onFailure: (Throwable) -> Unit = {}
): Job = launch(context, start) {
    onStart()
    action().onSuccess {
        onSuccess(it)
    }.onFailure {
        onFailure(it)
    }
}

inline fun <T> ViewModel.launch(
    context: CoroutineContext = CoroutineExceptionHandler { _, throwable -> onFailure(throwable) },
    start: CoroutineStart = CoroutineStart.DEFAULT,
    crossinline action: suspend () -> Result<T>,
    crossinline onStart: () -> Unit = {},
    crossinline onSuccess: (T?) -> Unit = {},
    crossinline onFailure: (Throwable) -> Unit = {}
): Job = viewModelScope.launch(context, start, action, onStart, onSuccess, onFailure)
