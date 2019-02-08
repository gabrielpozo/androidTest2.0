package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import kotlin.Exception

class ViewModelImpl(private val useCaseImpl: UseCaseImpl) : ViewModel() {

    private val onResultLiveData: MutableLiveData<Result<List<Category>>> = MutableLiveData()
    private val onNetworkErrorLiveData: MutableLiveData<Result<List<Category>>> = MutableLiveData()

    fun searchCategoriesOnNetwork() {
        useCaseImpl.execute {
            onSuccess {
                onResultLiveData.postValue(it)
            }

            onError {
                onNetworkErrorLiveData.postValue(it)
            }
        }
    }

    val categories: LiveData<Event<List<Category>?>> = Transformations.map(onResultLiveData) {
        it?.let { result ->
            Event(result.data)
        }
    }

    val networkErrors: LiveData<Event<Exception?>> = Transformations.map(onNetworkErrorLiveData) {
        it?.let { networkResult ->
            Event(networkResult.networkErrors)
        }

    }

    override fun onCleared() {
        super.onCleared()
        Log.d("GabrielC", "onCleared!!")
    }

}
