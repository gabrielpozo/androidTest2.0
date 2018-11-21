package com.example.gabrielpozoguzman.androidtest20.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesViewMvcImpl
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoryListItemViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoryListItemViewMvcImpl


class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {


    fun getCategoriesViewMvc(parent: ViewGroup?): CategoriesViewMvc {
        return CategoriesViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getCategoryListItemViewMvcImpl(parent: ViewGroup): CategoryListItemViewMvc {
        return CategoryListItemViewMvcImpl(mLayoutInflater, parent)
    }
}