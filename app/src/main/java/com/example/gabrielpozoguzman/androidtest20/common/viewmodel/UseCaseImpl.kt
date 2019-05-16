package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import android.arch.lifecycle.LiveData
import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import java.lang.Exception

class UseCaseImpl(private val categoriesRepository: CategoriesUseRepository) {
    fun getCategories(): LiveData<List<Category>> = categoriesRepository.allCategories
    fun clear() {

    }
}