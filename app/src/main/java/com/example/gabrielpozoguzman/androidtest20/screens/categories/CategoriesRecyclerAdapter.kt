package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class CategoriesRecyclerAdapter(val parent: LayoutInflater, var listenerAdapter: ListenerAdapter, private val viewMvcFactory: ViewMvcFactory) : RecyclerView.Adapter<CategoriesRecyclerAdapter.MyViewHolder>(), CategoryListItemViewMvc.ListenerCategoryItem {
    private var mCategories: List<Category> = ArrayList()

    interface ListenerAdapter {

        fun onCategoryCLicked(category: Category)
    }

    class MyViewHolder(val mViewMvc: CategoryListItemViewMvc) : RecyclerView.ViewHolder(mViewMvc.getRootView())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val categoryViewMvc: CategoryListItemViewMvc = viewMvcFactory.getCategoryListItemViewMvcImpl(parent)
        categoryViewMvc.registerListener(this)
        return MyViewHolder(categoryViewMvc)
    }

    override fun getItemCount(): Int {
        return mCategories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mViewMvc.bindCategory(mCategories.get(position))
    }

    fun bindCategories(categories: List<Category>) {
        mCategories = categories
        notifyDataSetChanged()
    }

    override fun onCategoryClicked(category: Category) {
        listenerAdapter.onCategoryCLicked(category)
    }
}
