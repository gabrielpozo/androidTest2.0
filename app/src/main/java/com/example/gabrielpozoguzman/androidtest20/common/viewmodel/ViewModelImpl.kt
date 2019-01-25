package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import java.lang.Exception

class ViewModelImpl(private val useCaseImpl: UseCaseImpl, private val resultLiveData: MutableLiveData<Result<List<Category>>>) : ViewModel() {

    private fun searchCategoriesOnNetwork() {
        useCaseImpl.execute {
            onSuccess {
                resultLiveData.postValue(it)
            }

            onError {
                resultLiveData.postValue(it)
            }
        }
    }

    val categories: LiveData<List<Category>> = Transformations.map(resultLiveData) {
        it.data
    }

    val networkErrors: LiveData<Exception> = Transformations.map(resultLiveData) {
        it.networkErrors
    }


}