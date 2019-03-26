package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import android.content.Context
import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoriesRoomDatabase
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoryDao
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsActivity
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedDispatcher
import dagger.Module
import dagger.Provides


@Module
class ApplicationDatabaseModule(val context: Context) {

    @Provides
    fun getCategoriesDao(): CategoryDao {
        return CategoriesRoomDatabase.getDatabase(context).categoriesDao()
    }

    @Provides
    fun getCategoriesUseRepository(categoryDao: CategoryDao, asyncTaskManager: AsyncTaskManager): CategoriesUseRepository {
        return CategoriesUseRepository(categoryDao, asyncTaskManager)
    }
}