package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoryDetailUseCase
import com.example.gabrielpozoguzman.androidtest20.common.MobgenPresenter
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.CoroutinesManager

class CategoryDetailsPresenter(private val fetchCategoryDetailType: FetchCategoryDetailUseCase, coroutinesManager: CoroutinesManager) : MobgenPresenter<CategoriesDetailsViewMvc>(coroutinesManager) {

    override fun onStart() {
        mViewMvc.showProgressIndication()
        launchCategoryDetails()
    }

    private fun launchCategoryDetails() {
        launchOnUITryCatch({
            val categoryDetailItem = fetchCategoryDetailType.execute(mViewMvc.categoryId)
            mViewMvc.hideProgressIndication()
            mViewMvc.bindCategoriesDetails(categoryDetailItem)

        }, {
            mViewMvc.hideProgressIndication()
            mViewMvc.showErrorDialog()

        })
    }

    override fun onStop() {
        //fetchCategoryDetailType.unregisterListener(this)
    }
}