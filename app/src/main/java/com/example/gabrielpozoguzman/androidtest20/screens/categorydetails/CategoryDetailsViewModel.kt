package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.*
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.CategoriesDataFactory
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.CategoriesDataSource
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.State
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedDispatcher
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedListener

class CategoryDetailsViewModel(private val categoriesNetworkRepository: CategoriesNetworkRepository, private val backPressedDispatcher: BackPressedDispatcher) : ViewModel(), BackPressedListener {

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
        if (queryLiveData.value == null) {
            dataSourceFactory = CategoriesDataFactory(categoriesNetworkRepository, categoryId)
            queryLiveData.postValue(categoryId)
        }
    }

    override fun onBackPressed(): Boolean {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates., implements from data binding
        return false
    }

    override fun onCleared() {
        super.onCleared()
    }

}