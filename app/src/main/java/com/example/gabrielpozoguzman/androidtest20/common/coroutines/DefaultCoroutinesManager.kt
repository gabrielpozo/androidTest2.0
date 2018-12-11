package com.example.gabrielpozoguzman.androidtest20.common.coroutines

import com.example.gabrielpozoguzman.androidtest20.utils.CoroutinesUtils.Companion.tryCatch
import com.example.gabrielpozoguzman.androidtest20.utils.CoroutinesUtils.Companion.tryCatchFinally
import com.example.gabrielpozoguzman.androidtest20.utils.CoroutinesUtils.Companion.tryFinally
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DefaultCoroutinesManager : CoroutinesManager, CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main


    protected val coroutinesJobs: MutableList<Job> = mutableListOf()

    @Synchronized
    override fun launchOnUI(block: suspend CoroutineScope.() -> Unit) {
        val job: Job = launch { block() }
        coroutinesJobs.add(job)
        job.invokeOnCompletion { coroutinesJobs.remove(job) }
    }

    @Synchronized
    override fun launchOnUITryCatch(
            tryBlock: suspend CoroutineScope.() -> Unit,
            catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
            handleCancellationExceptionManually: Boolean) {
        launchOnUI { tryCatch(tryBlock, catchBlock, handleCancellationExceptionManually) }
    }

    @Synchronized
    override fun launchOnUITryCatchFinally(
            tryBlock: suspend CoroutineScope.() -> Unit,
            catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
            finallyBlock: suspend CoroutineScope.() -> Unit,
            handleCancellationExceptionManually: Boolean) {
        launchOnUI { tryCatchFinally(tryBlock, catchBlock, finallyBlock, handleCancellationExceptionManually) }
    }

    @Synchronized
    override fun launchOnUITryFinally(
            tryBlock: suspend CoroutineScope.() -> Unit,
            finallyBlock: suspend CoroutineScope.() -> Unit,
            suppressCancellationException: Boolean) {
        launchOnUI { tryFinally(tryBlock, finallyBlock, suppressCancellationException) }
    }

    @Synchronized
    override fun cancelAllCoroutines() {
        val coroutinesJobsSize = coroutinesJobs.size

        if (coroutinesJobsSize > 0) {
            for (i in coroutinesJobsSize - 1 downTo 0) {
                coroutinesJobs[i].cancel()
            }
        }
    }

}