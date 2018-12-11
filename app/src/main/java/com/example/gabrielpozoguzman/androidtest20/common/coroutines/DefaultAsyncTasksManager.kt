package com.example.gabrielpozoguzman.androidtest20.common.coroutines

import android.support.annotation.CallSuper
import android.util.Log
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DefaultAsyncTasksManager: AsyncTaskManager, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO

    protected val deferredObjects: MutableList<Deferred<*>> = mutableListOf()

    @CallSuper
    @Synchronized
    override suspend fun <T> asyncTask(block: suspend CoroutineScope.() -> T): Deferred<T> {
        val deferred: Deferred<T> = async {
            Log.d("Gabriel","async Task Thread: ${Thread.currentThread().name}")
            block() }
        deferredObjects.add(deferred)
        deferred.invokeOnCompletion { deferredObjects.remove(deferred) }
        return deferred
    }

    override suspend fun <T> asyncAwait(block: suspend CoroutineScope.() -> T): T {
        return asyncTask(block).await()
    }

    @CallSuper
    @Synchronized
    override fun cancelAllAsync() {
        val deferredObjectsSize = deferredObjects.size

        if (deferredObjectsSize > 0) {
            for (i in deferredObjectsSize - 1 downTo 0) {
                deferredObjects[i].cancel()
            }
        }
    }

    @CallSuper
    @Synchronized
    override fun cleanup() {
        cancelAllAsync()
    }
}