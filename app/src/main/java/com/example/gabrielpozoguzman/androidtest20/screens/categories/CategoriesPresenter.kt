package com.example.gabrielpozoguzman.androidtest20.screens.categories

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.MobgenPresenter

class CategoriesPresenter(val categoriesFetchCategoriesUseCase: FetchCategoriesUseCase) : MobgenPresenter(), CategoriesViewMvc.Listener
        , FetchCategoriesUseCase.ListenerFetchCategoriesUseCase {

    lateinit var mViewMvc: CategoriesViewMvc

    override fun onStart() {
        categoriesFetchCategoriesUseCase.registerListener(this)
        mViewMvc.showProgressIndication()
        categoriesFetchCategoriesUseCase.fetchCategoriesAndNotify()
    }

    override fun onStop() {
        categoriesFetchCategoriesUseCase.unregisterListener(this)
    }

    override fun onCategoriesFetched(categories: List<Category>) {
        mViewMvc.hideProgressIndication()
        mViewMvc.bindCategories(categories.sortedWith(compareBy { it.title }))
    }

    override fun onCategoriesFetchFailed() {
    }

    override fun onCategoriesClicked() {

    }

    fun bindView(viewMvc: CategoriesViewMvc) {
        mViewMvc = viewMvc
        mViewMvc.registerLister(this)
    }
}