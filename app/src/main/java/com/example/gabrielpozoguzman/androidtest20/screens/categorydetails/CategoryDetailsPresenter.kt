package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoryDetailUseCase
import com.example.gabrielpozoguzman.androidtest20.common.MobgenPresenter
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.CoroutinesManager
import kotlinx.coroutines.delay


class CategoryDetailsPresenter(private val fetchCategoryDetailType: FetchCategoryDetailUseCase, coroutinesManager: CoroutinesManager) : MobgenPresenter<CategoriesDetailsViewMvc>(coroutinesManager) {

    override fun onStart() {
        mViewMvc.showProgressIndication()
        launchCategoryDetails()
    }

    private fun launchCategoryDetails() {
        launchOnUITryCatch({
            val categoryDetailItems = fetchCategoryDetailType.execute(mViewMvc.categoryId)
            delay(8000)
            mViewMvc.hideProgressIndication()
            mViewMvc.bindCategoriesDetails(categoryDetailItems)
        }, {
            mViewMvc.hideProgressIndication()
            mViewMvc.showErrorDialog()

        })
    }

    override fun onStop() {
        cancelAllCoroutinesManager()
        fetchCategoryDetailType.cleanup()
    }

    override fun onDestroy() {

    }
}