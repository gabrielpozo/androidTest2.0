package com.example.gabrielpozoguzman.androidtest20.screens.categories

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.MobgenPresenter
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.CoroutinesManager

class CategoriesPresenter(private val categoriesFetchCategoriesUseCase: FetchCategoriesUseCase, private val mScreensNavigator: ScreensNavigator, coroutinesManager: CoroutinesManager) : MobgenPresenter<CategoriesViewMvc>(coroutinesManager), CategoriesViewMvc.Listener
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
        mViewMvc.bindCategories(categories)
    }

    override fun onCategoriesFetchFailed() {

    }

    override fun onCategoriesClicked(category: Category) {
        mScreensNavigator.toCategoriesDetails(category.id)
    }

    override fun onDestroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}