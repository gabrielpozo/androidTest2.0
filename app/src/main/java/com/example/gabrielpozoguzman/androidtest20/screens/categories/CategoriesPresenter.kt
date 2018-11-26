package com.example.gabrielpozoguzman.androidtest20.screens.categories

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.MobgenPresenter
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator

class CategoriesPresenter(private val categoriesFetchCategoriesUseCase: FetchCategoriesUseCase, private val mScreensNavigator: ScreensNavigator) : MobgenPresenter<CategoriesViewMvc>(), CategoriesViewMvc.Listener
        , FetchCategoriesUseCase.ListenerFetchCategoriesUseCase {

    override fun onStart() {
        mViewMvc.registerListener(this)
        categoriesFetchCategoriesUseCase.registerListener(this)

        mViewMvc.showProgressIndication()
        categoriesFetchCategoriesUseCase.fetchCategoriesAndNotify()
    }

    override fun onStop() {
        mViewMvc.unregisterListener(this)
        categoriesFetchCategoriesUseCase.unregisterListener(this)
    }

    override fun onCategoriesFetched(categories: List<Category>) {
        mViewMvc.hideProgressIndication()
        mViewMvc.bindCategories(categories.sortedWith(compareBy { it.title }))
    }

    override fun onCategoriesFetchFailed() {

    }

    override fun onCategoriesClicked() {
        mScreensNavigator.toCategoriesDetails("")
    }
}