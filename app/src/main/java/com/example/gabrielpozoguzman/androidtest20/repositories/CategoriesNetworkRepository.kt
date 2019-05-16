package com.example.gabrielpozoguzman.androidtest20.repositories

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.interfaces.ParameterUseCase
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.utils.extensions.convertToCategoryDetailModel
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.Single

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
            onError(result.errorBody()?.string() ?: " UnKnown error")
        }
    }


    fun getCategories(): Observable<List<Category>> {
        val categories: MutableList<Category> = ArrayList()
        categories.add(Category(1, "Big Data", "2342"))
        categories.add(Category(2, "Terrorism", "-9898"))
        categories.add(Category(3, "Climate change", "-9666"))

        return Observable.just(categories)
        // return mobgenApi.getCategoriesRx()
    }
}