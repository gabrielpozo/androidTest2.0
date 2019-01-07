package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import android.content.Context
import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoriesRoomDatabase
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoryDao
import dagger.Module
import dagger.Provides


@Module
class ApplicationDatabaseModule(val context: Context) {

    @Provides
    fun getCategoriesDao(): CategoryDao {
        return CategoriesRoomDatabase.getDatabase(context).categoriesDao()
    }

    @Provides
    fun getCategoriesUseRepository(categoryDao: CategoryDao): CategoriesUseRepository {
        return CategoriesUseRepository(categoryDao)
    }

}