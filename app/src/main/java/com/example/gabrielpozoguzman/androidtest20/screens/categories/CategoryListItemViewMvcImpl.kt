package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.BaseObservable
import java.util.ArrayList

class CategoryListItemViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseObservable<CategoryListItemViewMvc.ListenerCategoryItem>(), CategoryListItemViewMvc {

    private lateinit var mCategory: Category
    private val mTxtTitle: TextView by lazy { findViewById<TextView>(R.id.txt_title) }

    init {
        //mTxtTitle = findViewById(R.id.txt_title)
        setRootView(inflater.inflate(R.layout.layout_category_list_item, parent, false))

        getRootView().setOnClickListener {
            for (listener in listeners) {
                listener.onCategoryClicked(mCategory)
            }
        }
    }

    override fun bindCategory(category: Category) {
        mCategory = category
        mTxtTitle.apply {
            text = category.title
        }
    }

}
