package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.example.gabrielpozoguzman.androidtest20.categories.*
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.CategoriesDataFactory
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.CategoriesDataSource
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.State
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository

class CategoryDetailsViewModel(private val categoriesNetworkRepository: CategoriesNetworkRepository) : ViewModel() {

    private val queryLiveData = MutableLiveData<String>()
    private val config: PagedList.Config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(4)
            .setEnablePlaceholders(false)
            .build()

    private lateinit var dataSourceFactory: CategoriesDataFactory

    /**
     * this variables will be observed from the activity/fragment
     */
    val categoriesList: LiveData<PagedList<CategoryDetailType>> = Transformations.switchMap(queryLiveData) {
        LivePagedListBuilder<Int, CategoryDetailType>(dataSourceFactory, config).build()
    }

    /**
     *this variables will be observed from the activity/fragment
     */
    fun getState(): LiveData<State> = Transformations.switchMap<CategoriesDataSource,
            State>(dataSourceFactory.categoriesMutableLiveData, CategoriesDataSource::state)

    /**
     * Search a repository based on a query string Id.
     */
    fun loadCategoriesDataNow(categoryId: String) {
        dataSourceFactory = CategoriesDataFactory(categoriesNetworkRepository, categoryId)
        queryLiveData.postValue(categoryId)
    }

}