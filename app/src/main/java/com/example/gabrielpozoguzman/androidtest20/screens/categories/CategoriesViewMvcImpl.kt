package com.example.gabrielpozoguzman.androidtest20.screens.categories

import com.example.gabrielpozoguzman.androidtest20.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CategoriesViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) : CategoriesViewMvc {
    private val mRootView: View

    init {
        mRootView = inflater.inflate(R.layout.layout_content_frame, parent, false)

    }

    override fun registerLister(listener: CategoriesViewMvc.Listener) {

    }

    override fun unregisterListener(listener: CategoriesViewMvc.Listener) {

    }

    override fun getRootView(): View {
        return mRootView
    }
}
