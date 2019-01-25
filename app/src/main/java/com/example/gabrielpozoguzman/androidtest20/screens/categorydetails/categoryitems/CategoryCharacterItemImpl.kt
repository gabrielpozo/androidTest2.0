package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.categoryitems

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryCharacter
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.BaseMvcView

class CategoryCharacterItemImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseMvcView(), CategoryDetailsItemViewMvc {
    init {
        setRootView(inflater.inflate(R.layout.layout_category_list_item, parent, false))
    }

    override fun bindCategoryDetails(categoryDetailType: CategoryDetailType) {
        Log.d("Gabriel", "Name of the character: ${(categoryDetailType as CategoryCharacter).name}")
    }

}