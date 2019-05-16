package com.example.gabrielpozoguzman.androidtest20.common.pagelist

import android.support.v7.util.DiffUtil
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType


class CategoriesDiffUtil(private val oldList: List<CategoryDetailType>, private val newList: List<CategoryDetailType>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].categoryType == newList[newItemPosition].categoryType
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].equals(newList[newItemPosition])
    }


}

val diffCallback = object : DiffUtil.ItemCallback<CategoryDetailType>() {

    lateinit var oldList: List<CategoryDetailType>

    lateinit var newList: List<CategoryDetailType>

    override fun areItemsTheSame(oldItem: CategoryDetailType, newItem: CategoryDetailType): Boolean {
        return oldItem
    }

    override fun areContentsTheSame(oldItem: CategoryDetailType, newItem: CategoryDetailType): Boolean {
        return oldItem == newItem
    }

}

