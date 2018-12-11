package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.BaseObservable
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FetchCategoriesUseCase(private val mobgenApi: MobgenApi) : BaseObservable<FetchCategoriesUseCase.ListenerFetchCategoriesUseCase>() {

    interface ListenerFetchCategoriesUseCase {
        fun onCategoriesFetched(categories: List<Category>)
        fun onCategoriesFetchFailed()
    }

    fun fetchCategoriesAndNotify() {
        mobgenApi.getCategories()
                .enqueue(object : Callback<List<Category>> {
                    override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                        if (response.isSuccessful()) {
                            notifySuccess(response.body()!!)
                        } else {
                            notifyFailure()
                        }
                    }

                    override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                        notifyFailure()
                    }
                })
    }

    private fun notifySuccess(categories: List<Category>) {
        listeners.forEach { it.onCategoriesFetched(categories.sortedBy { it.title }) }
    }

    private fun notifyFailure() {
        listeners.forEach { it.onCategoriesFetchFailed() }
    }
}