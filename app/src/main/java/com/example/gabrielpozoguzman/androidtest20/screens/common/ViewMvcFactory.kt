package com.example.gabrielpozoguzman.androidtest20.screens.common

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesViewMvcImpl
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoryListItemViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoryListItemViewMvcImpl
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoriesDetailsViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.category_items.CategoryDetailsItemViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsViewMvcImpl
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.category_items.*


class ViewMvcFactory(private val mLayoutInflater: LayoutInflater) {

    fun getCategoriesViewMvc(parent: ViewGroup?): CategoriesViewMvc {
        return CategoriesViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getCategoryListItemViewMvcImpl(parent: ViewGroup): CategoryListItemViewMvc {
        return CategoryListItemViewMvcImpl(mLayoutInflater, parent)
    }

    fun getCategoryDetailsViewMvc(parent: ViewGroup?): CategoriesDetailsViewMvc {
        return CategoryDetailsViewMvcImpl(mLayoutInflater, parent, this)
    }

    fun getCategoryBookItemImpl(parent: ViewGroup): CategoryDetailsItemViewMvc {
        return CategoryBookItemImpl(mLayoutInflater, parent)
    }

    fun getCategoryHouseItemImpl(parent: ViewGroup): CategoryDetailsItemViewMvc {
        return CategoryHouseItemImpl(mLayoutInflater, parent)
    }

    fun getCategoryCharacterItemImpl(parent: ViewGroup): CategoryDetailsItemViewMvc {
        return CategoryCharacterItemImpl(mLayoutInflater, parent)
    }
}