package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.utils.CoroutinesUtils.Companion.tryCatch
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DefaultCoroutines(override val coroutineContext: CoroutineContext = Dispatchers.Main, private val backgroundContext: CoroutineContext = Dispatchers.IO) : CoroutineScope, CoroutinesManager {

    private val coroutinesJobs: MutableList<Job> = mutableListOf()
    private val deferredObjects: MutableList<Deferred<*>> = mutableListOf()

    override fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        val job: Job = launch { block() }
        coroutinesJobs.add(job)
        job.invokeOnCompletion { coroutinesJobs.remove(job) }
    }

    override fun launchOnUITryCatch(
            tryBlock: suspend CoroutineScope.() -> Unit,
            catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
            handleCancellationExceptionManually: Boolean) {
        launchOnUI { tryCatch(tryBlock, catchBlock, handleCancellationExceptionManually) }
    }

    override suspend fun <T> asyncTask(block: suspend CoroutineScope.() -> T): Deferred<T> {
        val deferred: Deferred<T> = async(backgroundContext) { block() }
        deferredObjects.add(deferred)
        deferred.invokeOnCompletion { deferredObjects.remove(deferred) }
        return deferred
    }
}