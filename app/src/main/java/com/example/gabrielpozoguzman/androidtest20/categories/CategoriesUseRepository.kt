package com.example.gabrielpozoguzman.androidtest20.categories

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoryDao

class CategoriesUseRepository(private val categoryDao: CategoryDao, asyncTaskManager: AsyncTaskManager) : AsyncTaskManager by asyncTaskManager {
    val allCategories: LiveData<List<Category>> = categoryDao.getAllCategories()

    @WorkerThread
    suspend fun insert(category: Category) = asyncTask {
        categoryDao.insert(category)
    }
}