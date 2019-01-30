package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import kotlinx.coroutines.delay

abstract class BaseUseCase2<P, T>(coroutinesManager: DefaultCoroutines) : CoroutinesManager by coroutinesManager {
    private var resultReporter = ResultReporterImp<T>()
    private val maxValue = 8000L

    /**
     * it will keep retrying the network call in case it fails
     */
    private suspend fun retryIO(block: suspend () -> Result<T>): Result<T> {
        var curlDelay = 1000L
        while (curlDelay < maxValue) {
            //val resultBlock = block()
            Log.d("GabrielC", "RetryIO before on Success")
            if (block().resultState == ResultState.SUCCESS) return block()
            Log.d("GabrielC", "RetryIO after on Success")

            delay(curlDelay)
            Log.d("GabrielC", "RetryIO delay $curlDelay")
            curlDelay = (curlDelay * 2).coerceAtMost(maxValue)
        }

        Log.d("GabrielC", "RetryIO after WHILE! $curlDelay")
        return block()
    }

    protected abstract fun doInBackground(params: P? = null): Result<T>

    fun execute(params: P? = null, reporter: (ResultReporterImp<T>.() -> Unit)) {
        resultReporter.reporter()
        launchOnUITryCatch({
            val result = asyncTask {
                retryIO {
                    doInBackground(params)
                }
            }.await()
            Log.d("GabrielC", " execute!!")
            when (result.resultState) {
                ResultState.SUCCESS -> resultReporter.onSuccess(result)
                else -> {
                    resultReporter.onError(result)
                }
            }
        }, {
            resultReporter.onErrorCoroutines()
        })
    }

}