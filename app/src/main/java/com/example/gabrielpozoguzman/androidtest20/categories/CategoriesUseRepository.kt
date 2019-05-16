package com.example.gabrielpozoguzman.androidtest20.categories

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repositories.database.CategoryDao

class CategoriesUseRepository(private val categoryDao: CategoryDao, asyncTaskManager: AsyncTaskManager) {
    val allCategories: LiveData<List<Category>> = categoryDao.getAllCategories()

    @WorkerThread
    fun insert(category: Category) {
        categoryDao.insert(category)
    }
}