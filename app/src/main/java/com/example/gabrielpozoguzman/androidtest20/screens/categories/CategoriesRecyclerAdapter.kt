package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.Category

class CategoriesRecyclerAdapter(val inflater: LayoutInflater, var listenerAdapter: ListenerAdapter) : RecyclerView.Adapter<CategoriesRecyclerAdapter.MyViewHolder>(), CategoryListItemViewMvc.ListenerCategoryItem {
    private var mCategories: ArrayList<Category> = ArrayList()

    interface ListenerAdapter {

        fun onCategoryCLicked(category: Category)
    }

    class MyViewHolder(val mViewMvc: CategoryListItemViewMvc) : RecyclerView.ViewHolder(mViewMvc.getRootView())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val categoryViewMvc: CategoryListItemViewMvc = CategoryListItemViewMvcImpl(inflater, parent)
        categoryViewMvc.registerListener(this)
        return MyViewHolder(categoryViewMvc)
    }

    override fun getItemCount(): Int {
        return mCategories.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.mViewMvc.bindCategory(mCategories.get(position))
    }

    fun bindCategories(categories: ArrayList<Category>) {
        mCategories = categories
        notifyDataSetChanged()
    }

    override fun onCategoryClicked(category: Category) {
        listenerAdapter.onCategoryCLicked(category)
    }
}
