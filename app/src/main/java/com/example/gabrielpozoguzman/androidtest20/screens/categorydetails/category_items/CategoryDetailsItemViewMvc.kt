package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.category_items

import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.ViewMvc

interface CategoryDetailsItemViewMvc : ViewMvc {
    fun bindCategoryDetails(categoryDetailType: CategoryDetailType)
}