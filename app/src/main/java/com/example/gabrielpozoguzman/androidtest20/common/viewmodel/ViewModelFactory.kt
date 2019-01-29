package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return providerMap[modelClass]?.get() as T

    }

}