package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.view.View
import com.example.gabrielpozoguzman.androidtest20.categories.Category

interface CategoriesViewMvc {
    interface Listener {
       fun onCategoriesClicked()
    }

    fun registerLister(listener: Listener)
    fun unregisterListener(listener: Listener)
    fun getRootView(): View
    fun bindCategories(categories: ArrayList<Category>)
}