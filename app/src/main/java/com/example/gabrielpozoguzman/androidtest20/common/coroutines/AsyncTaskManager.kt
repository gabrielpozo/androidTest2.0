package com.example.gabrielpozoguzman.androidtest20.common.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred

interface AsyncTaskManager {
    suspend fun <T> asyncTask(block: suspend CoroutineScope.() -> T): Deferred<T>

    suspend fun <T> asyncAwait(block: suspend CoroutineScope.() -> T): T

    fun cancelAllAsync()

    fun cleanup()
}