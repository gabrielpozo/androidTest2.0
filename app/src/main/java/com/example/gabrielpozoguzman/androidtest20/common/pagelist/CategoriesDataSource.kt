package com.example.gabrielpozoguzman.androidtest20.common.pagelist

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PageKeyedDataSource
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository

class CategoriesDataSource(private val categoriesNetworkRepository: CategoriesNetworkRepository,
                           val categoryId: String) : PageKeyedDataSource<Int, CategoryDetailType>() {

    var state: MutableLiveData<State> = MutableLiveData()

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, CategoryDetailType>) {
        val key = params.requestedLoadSize
        categoriesNetworkRepository.getCategoryDetailsList(1.toString(), categoryId, {
            callback.onResult(it, null, 2)
        }, {
            state.postValue(State.ERROR)
        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, CategoryDetailType>) {
        val nextKey = params.key
        categoriesNetworkRepository.getCategoryDetailsList(nextKey.toString(), categoryId, {
            callback.onResult(it, nextKey + 1)
        }, {
            state.postValue(State.ERROR)
        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, CategoryDetailType>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}