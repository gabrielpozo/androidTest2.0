package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import java.util.ArrayList

class CategoryListItemViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup) : CategoryListItemViewMvc {
    private val mRootView: View = inflater.inflate(R.layout.layout_category_list_item, parent, false)
    private val mListeners = ArrayList<CategoryListItemViewMvc.ListenerCategoryItem>(1)
    private lateinit var mCategory: Category
    private val mTxtTitle: TextView

    init {
        mTxtTitle = findViewById(R.id.txt_title)
        getRootView().setOnClickListener {
            for (listener in mListeners) {
                listener.onCategoryClicked(mCategory)
            }
        }
    }

    override fun registerListener(listener: CategoryListItemViewMvc.ListenerCategoryItem) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: CategoryListItemViewMvc.ListenerCategoryItem) {
        mListeners.add(listener)
    }

    private fun <T : View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    override fun getRootView(): View {
        return mRootView
    }

    override fun bindCategory(category: Category) {
        mCategory = category
        mTxtTitle.setText(category.title)
    }

}
