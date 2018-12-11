package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.*
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.category_items.CategoryDetailsItemViewMvc
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class CategoriesDetailAdapter(val parent: LayoutInflater, private val viewMvcFactory: ViewMvcFactory) : RecyclerView.Adapter<ViewHolder>() {

    private var mCategoryDetailsList: List<CategoryDetailType> = ArrayList()

    companion object {
        const val TYPE_BOOK = 0
        const val TYPE_HOUSE = 1
        const val TYPE_CHARACTER = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (mCategoryDetailsList[position].categoryType) {
            CategoryDetailType.BOOK -> TYPE_BOOK
            CategoryDetailType.HOUSE -> TYPE_HOUSE
            CategoryDetailType.CHARACTER -> TYPE_CHARACTER
            else -> TYPE_BOOK
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_BOOK -> BookViewHolder(viewMvcFactory.getCategoryBookItemImpl(parent))
            TYPE_HOUSE -> HouseViewHolder(viewMvcFactory.getCategoryHouseItemImpl(parent))
            TYPE_CHARACTER -> CharacterViewHolder(viewMvcFactory.getCategoryCharacterItemImpl(parent))
            else -> BookViewHolder(viewMvcFactory.getCategoryBookItemImpl(parent))
        }
    }

    override fun getItemCount(): Int {
        return mCategoryDetailsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as CategoryViewHolder).mViewMvc.bindCategoryDetails(mCategoryDetailsList[position])
    }

    fun bindCategories(categorySchemas: List<CategoryDetailType>) {
        mCategoryDetailsList = ArrayList<CategoryDetailType>(categorySchemas)
        notifyDataSetChanged()
    }

    interface CategoryViewHolder {
        val mViewMvc: CategoryDetailsItemViewMvc
    }

    class CharacterViewHolder(override val mViewMvc: CategoryDetailsItemViewMvc)
        : RecyclerView.ViewHolder(mViewMvc.getRootView()), CategoryViewHolder

    class HouseViewHolder(override val mViewMvc: CategoryDetailsItemViewMvc)
        : RecyclerView.ViewHolder(mViewMvc.getRootView()), CategoryViewHolder

    class BookViewHolder(override val mViewMvc: CategoryDetailsItemViewMvc)
        : RecyclerView.ViewHolder(mViewMvc.getRootView()), CategoryViewHolder


}