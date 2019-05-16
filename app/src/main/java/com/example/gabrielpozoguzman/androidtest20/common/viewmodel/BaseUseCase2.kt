package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import kotlinx.coroutines.delay

/**
 *Open close Principle where it this base use class is close for modifications but open for extensions
 *
 * this baseUseCase class will make clients more resilient when they need to change or pivot to another business model
 * since they are pointing to their abstraction and not to their implementation.
 * clients doesn't need to know about their implementation
 */
abstract class BaseUseCase2<P, T>(coroutinesManager: DefaultCoroutinesViewModel) : CoroutinesManagerViewModel by coroutinesManager {
    private var resultReporter = ResultReporterImp<T>()
    private val maxValue = 16000L

    /**
     * it will keep retrying the network call in case it fails at least 16 seconds
     */
    private suspend fun retryIO(params: P? = null): Result<T> {
        var result: Result<T> = Result(ResultState.ERROR)
        var curlDelay = 1000L
        while (curlDelay < maxValue) {
            result = doInBackground(params)
            if (result.resultState == ResultState.SUCCESS) {
                return result
            }
            delay(curlDelay)
            curlDelay = (curlDelay * 2).coerceAtMost(maxValue)
        }
        return result
    }


    protected abstract suspend fun doInBackground(params: P? = null): Result<T>

    fun execute(params: P? = null, reporter: (ResultReporterImp<T>.() -> Unit)) {
        resultReporter.reporter()
        launchOnUITryCatch({
            val result = asyncTask {
                retryIO(params)
            }.await()
            when (result.resultState) {
                ResultState.SUCCESS -> resultReporter.onSuccess(result)
                else -> resultReporter.onError(result)
            }

        }, {
            resultReporter.onErrorCoroutines()
        })
    }

}