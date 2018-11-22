package com.example.gabrielpozoguzman.androidtest20.screens.categories

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.BaseObservableViewMvc

interface CategoriesViewMvc : BaseObservableViewMvc<CategoriesViewMvc.Listener> {
    interface Listener {
        fun onCategoriesClicked()
    }

    fun bindCategories(categories: List<Category>)
    fun showProgressIndication()
    fun hideProgressIndication()
}