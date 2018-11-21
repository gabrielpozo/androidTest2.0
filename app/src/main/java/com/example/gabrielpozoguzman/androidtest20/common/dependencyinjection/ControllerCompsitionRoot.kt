package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection

import android.app.Activity
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesPresenter
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class ControllerCompositionRoot(val mCompositionRoot: CompositionRoot, val mActivity: Activity) {

    fun getMobgenApi(): MobgenApi {
        return mCompositionRoot.getMobgenApi()
    }

    private fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    fun getViewMvcFactory(): ViewMvcFactory {
        return ViewMvcFactory(getLayoutInflater())
    }

    fun getFetchCategoriesUseCase(): FetchCategoriesUseCase {
        return FetchCategoriesUseCase(getMobgenApi())
    }

    fun getCategoriesPresenter(): CategoriesPresenter {
        return CategoriesPresenter(getFetchCategoriesUseCase())
    }
}