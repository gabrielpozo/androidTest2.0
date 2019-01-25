package com.example.gabrielpozoguzman.androidtest20.common.pagelist

import android.support.v7.util.DiffUtil
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType


val diffCallback = object : DiffUtil.ItemCallback<CategoryDetailType>() {
    override fun areItemsTheSame(oldItem: CategoryDetailType, newItem: CategoryDetailType): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: CategoryDetailType, newItem: CategoryDetailType): Boolean {
        return oldItem == newItem
    }

}

