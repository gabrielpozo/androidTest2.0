package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import kotlin.Exception

class ViewModelImpl(private val useCaseImpl: UseCaseImpl) : ViewModel() {
    fun getAllCategories(): LiveData<List<Category>> {
        return useCaseImpl.getCategories()
    }

    override fun onCleared() {
        super.onCleared()
        useCaseImpl.clear()
    }

}
