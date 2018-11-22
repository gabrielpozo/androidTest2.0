package com.example.gabrielpozoguzman.androidtest20.screens.categories

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.BaseObservableViewMvc

interface CategoryListItemViewMvc: BaseObservableViewMvc<CategoryListItemViewMvc.ListenerCategoryItem> {
    interface ListenerCategoryItem {
        fun onCategoryClicked(category: Category)
    }
    fun bindCategory(category: Category)

}
