package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.BaseObservable
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.techyourchance.mvc.networking.questions.CategoriesSchema
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchCategoriesUseCase(private val mobgenApi: MobgenApi) : BaseObservable<FetchCategoriesUseCase.ListenerFetchCategoriesUseCase>() {

    interface ListenerFetchCategoriesUseCase {
        fun onCategoriesFetched(questions: List<Category>)
        fun onCategoriesFetchFailed()
    }

    fun fetchCategoriesAndNotify() {
        mobgenApi.getCategories()
                .enqueue(object : Callback<List<CategoriesSchema>> {
                    override fun onResponse(call: Call<List<CategoriesSchema>>, response: Response<List<CategoriesSchema>>) {
                        if (response.isSuccessful()) {
                            notifySuccess(response.body()!!)

                        } else {
                            notifyFailure()
                        }
                    }

                    override fun onFailure(call: Call<List<CategoriesSchema>>, t: Throwable) {
                        notifyFailure()
                    }
                })
    }

    private fun notifySuccess(categoriesSchema: List<CategoriesSchema>) {
        val categories = ArrayList<Category>()
        categoriesSchema.forEach {
            categories.add(Category(it.id, it.title, it.href))
        }
        listeners.forEach { it.onCategoriesFetched(categories) }
    }

    private fun notifyFailure() {
        listeners.forEach { it.onCategoriesFetchFailed() }
    }
}