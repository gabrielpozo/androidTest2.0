package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class ResultReporterMine<T>(var data: MutableLiveData<T>? = null, var netWorkErrors: MutableLiveData<String>? = null) {

    /***
     *
     */

    /*fun onSuccess(successBlock: (T) -> Unit) {
        _onSuccess = successBlock
    }

    override fun onError(onError: Result<T>) {
        _onError?.invoke(onError)
    }*/

}