package com.example.gabrielpozoguzman.androidtest20.repository

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailSchemaItem
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi

class CategoriesNetworkRepository(private val mobgenApi: MobgenApi) {

    suspend fun getCategories(): List<Category> {
        return mobgenApi.getCategories2().await()
    }

    suspend fun getCategoryDetailsList(categoryId: String): List<CategoryDetailSchemaItem> {
        return when (categoryId) {
            CategoryDetailType.BOOK -> mobgenApi.getCategoryListBook().await()
            CategoryDetailType.CHARACTER -> mobgenApi.getCategoryListHouse().await()
            CategoryDetailType.HOUSE -> mobgenApi.getCategoryListHouse().await()
            else -> mobgenApi.getCategoryListBook().await()
        }
    }
}