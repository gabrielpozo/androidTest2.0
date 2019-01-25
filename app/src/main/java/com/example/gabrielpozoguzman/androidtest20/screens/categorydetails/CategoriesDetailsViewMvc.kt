package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.arch.paging.PagedList
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.ViewMvc

interface CategoriesDetailsViewMvc : ViewMvc {
    var categoryId: String
    fun bindCategoriesDetails(categorySchemas: PagedList<CategoryDetailType>)
    fun showProgressIndication()
    fun hideProgressIndication()
    fun showErrorDialog()

}