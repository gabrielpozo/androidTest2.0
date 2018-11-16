package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.view.View
import com.example.gabrielpozoguzman.androidtest20.categories.Category

interface CategoryListItemViewMvc {
    interface ListenerCategoryItem {
        fun onCategoryClicked(category: Category)
    }

    fun registerListener(listener: ListenerCategoryItem)
    fun unregisterListener(listener: ListenerCategoryItem)
    fun bindCategory(category: Category)
    fun getRootView(): View

}
