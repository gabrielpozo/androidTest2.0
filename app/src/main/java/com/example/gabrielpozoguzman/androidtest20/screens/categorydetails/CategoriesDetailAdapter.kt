package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.*
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.diffCallback
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.categoryitems.CategoryDetailsItemViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class CategoriesDetailAdapter(val parent: LayoutInflater, private val viewMvcFactory: ViewMvcFactory) : PagedListAdapter<CategoryDetailType, ViewHolder>(diffCallback) {

    companion object Constants {
        const val TYPE_BOOK = 0
        const val TYPE_HOUSE = 1
        const val TYPE_CHARACTER = 2
    }

    override fun getItemViewType(position: Int): Int {
        getItem(position)?.let {
            return when (it.categoryType) {
                CategoryDetailType.BOOK -> TYPE_BOOK
                CategoryDetailType.HOUSE -> TYPE_HOUSE
                CategoryDetailType.CHARACTER -> TYPE_CHARACTER
                else -> TYPE_BOOK
            }
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        TYPE_BOOK -> {
            BookViewHolder(viewMvcFactory.getCategoryBookItemImpl(parent))
        }
        TYPE_HOUSE -> HouseViewHolder(viewMvcFactory.getCategoryHouseItemImpl(parent))
        TYPE_CHARACTER -> CharacterViewHolder(viewMvcFactory.getCategoryCharacterItemImpl(parent))
        else -> BookViewHolder(viewMvcFactory.getCategoryBookItemImpl(parent))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            (holder as CategoryViewHolder).mViewMvc.bindCategoryDetails(it)
        }
    }

    interface CategoryViewHolder {
        val mViewMvc: CategoryDetailsItemViewMvc
    }

    class CharacterViewHolder(override val mViewMvc: CategoryDetailsItemViewMvc)
        : RecyclerView.ViewHolder(mViewMvc.getRootView()), CategoryViewHolder

    class HouseViewHolder(override val mViewMvc: CategoryDetailsItemViewMvc)
        : RecyclerView.ViewHolder(mViewMvc.getRootView()), CategoryViewHolder

    class BookViewHolder(override val mViewMvc: CategoryDetailsItemViewMvc)
        : RecyclerView.ViewHolder(mViewMvc.getRootView()), CategoryViewHolder{}


}
