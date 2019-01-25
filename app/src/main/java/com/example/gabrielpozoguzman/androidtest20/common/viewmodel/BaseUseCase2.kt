package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState

abstract class BaseUseCase2<P, T>(coroutinesManager: DefaultCoroutines) : CoroutinesManager by coroutinesManager {
    private var resultReporter = ResultReporterImp<T>()

    protected abstract fun doInBackground(params: P? = null): Result<T>

    fun execute(params: P? = null, reporter: (ResultReporterImp<T>.() -> Unit)) {
        launchOnUI {
            val result = asyncTask {
                doInBackground(params)
            }.await()
            when (result.resultState) {
                ResultState.SUCCESS -> resultReporter.onSuccess(result)
                else -> resultReporter.onError(result)
            }
            reporter(resultReporter)
        }
    }

}