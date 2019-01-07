package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import android.content.Context
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

open class PresentationModule(val mActivity: Context) {


    fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    fun getViewMvcFactory(layoutInflater: LayoutInflater): ViewMvcFactory {
        return ViewMvcFactory(layoutInflater) //return getCategoryListItemViewMvcImpl --> CategoryListItemViewMvcImpl(mLayoutInflater, parent, navigationDrawer, getImageLoader())
    }
}