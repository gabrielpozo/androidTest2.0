package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.view.View

interface CategoriesViewMvc {
    interface Listener {
       fun onCategoriesClicked()
    }

    fun registerLister(listener: Listener)
    fun unregisterListener(listener: Listener)
    fun getRootView(): View
}