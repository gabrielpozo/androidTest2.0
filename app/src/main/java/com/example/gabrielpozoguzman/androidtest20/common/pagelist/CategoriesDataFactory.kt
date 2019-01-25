package com.example.gabrielpozoguzman.androidtest20.common.pagelist

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository

class CategoriesDataFactory(private val categoriesNetworkRepository: CategoriesNetworkRepository, val categoryId: String) : DataSource.Factory<Int, CategoryDetailType>() {


    var categoriesMutableLiveData: MutableLiveData<CategoriesDataSource> = MutableLiveData()

    override fun create(): DataSource<Int, CategoryDetailType> {
        val categoriesDataSource = CategoriesDataSource(categoriesNetworkRepository, categoryId)
        categoriesMutableLiveData.postValue(categoriesDataSource)
        return categoriesDataSource
    }
}