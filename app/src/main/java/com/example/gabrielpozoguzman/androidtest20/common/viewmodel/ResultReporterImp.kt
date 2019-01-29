package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

class ResultReporterImp<T> : ResultReporter<T> {

    private var _before: (() -> Unit)? = null
    private var _onSuccess: ((data: Result<T>) -> Unit)? = null
    private var _onError: ((errorResult: Result<T>) -> Unit)? = null
    private var _finally: (() -> Unit)? = null

    override fun beforeResult() {
        _before?.invoke()
    }

    fun beforeResult(beforeBlock: () -> Unit) {
        _before = beforeBlock
    }

    override fun onSuccess(data: Result<T>) {
        _onSuccess?.invoke(data)
    }

    fun onSuccess(successBlock: (Result<T>) -> Unit) {
        _onSuccess = successBlock
    }

    override fun onError(onError: Result<T>) {
        _onError?.invoke(onError)
    }

    fun onError(errorBlock: (Result<T>) -> Unit) {
        _onError = errorBlock
    }

    override fun finally() {
        _finally?.invoke()
    }

    fun finally(finallyBlock: () -> Unit) {
        _finally = finallyBlock
    }

    override fun onErrorCoroutines() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

interface ResultReporter<T> {
    fun beforeResult()
    fun onSuccess(data: Result<T>)
    fun onError(onError: Result<T>)
    fun finally()
    fun onErrorCoroutines()
}
