package com.example.gabrielpozoguzman.androidtest20.repository

import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.utils.extensions.convertToCategoryDetailModel

class CategoriesNetworkRepository(private val mobgenApi: MobgenApi) {

    fun getCategoryDetailsList(page: String, categoryId: String, onSuccess: (repos: List<CategoryDetailType>) -> Unit, onError: (repos: String) -> Unit) {
        val result = when (categoryId) {
            CategoryDetailType.BOOK -> mobgenApi.getCategoryListBook(page, "4").execute()
            CategoryDetailType.CHARACTER -> mobgenApi.getCategoryListCharacter(page, "4").execute()
            CategoryDetailType.HOUSE -> mobgenApi.getCategoryListHouse(page, "4").execute()
            else -> mobgenApi.getCategoryListBook(page, "4").execute()
        }
        if (result.isSuccessful) {
            onSuccess(result.body()?.convertToCategoryDetailModel(categoryId) ?: emptyList())
        } else {
            Log.d("Gabriel", "getCategories ERROR")
            onError(result.errorBody()?.string() ?: " UnKnown error")
        }

    }


}