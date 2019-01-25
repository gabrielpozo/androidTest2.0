package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsViewModel
import java.lang.RuntimeException

class ViewModelFactory(private val categoriesNetworkRepository: CategoriesNetworkRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CategoryDetailsViewModel(categoriesNetworkRepository) as T
        } else {
            throw  RuntimeException("invalid model class $modelClass")
        }
    }

}