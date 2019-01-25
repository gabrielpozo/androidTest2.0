package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred

interface CoroutinesManager {

    fun launchOnUI(block: suspend CoroutineScope.() -> Unit)
    fun launchOnUITryCatch(
            tryBlock: suspend CoroutineScope.() -> Unit,
            catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
            handleCancellationExceptionManually: Boolean = false)
    suspend fun <T> asyncTask(block: suspend CoroutineScope.() -> T): Deferred<T>
    //suspend fun <T> asyncAwait(block: suspend CoroutineScope.() -> T): T
}