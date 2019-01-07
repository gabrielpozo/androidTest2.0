package com.example.gabrielpozoguzman.androidtest20.categories

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoryDao

class CategoriesUseRepository(private val categoryDao: CategoryDao) {
    val allCategories: LiveData<List<Category>> = categoryDao.getAllCategories()

    @WorkerThread
    fun insert(category: Category) {
        categoryDao.insert(category)
    }
}