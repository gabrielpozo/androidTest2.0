package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.categoryitems

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryBook
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.BaseMvcView

class CategoryBookItemImpl(inflater: LayoutInflater, parent: ViewGroup) : BaseMvcView(), CategoryDetailsItemViewMvc {
    private val authors: TextView by lazy { findViewById<TextView>(R.id.authorValue) }
    private val isbn: TextView by lazy { findViewById<TextView>(R.id.isbnValue) }
    private val pages: TextView by lazy { findViewById<TextView>(R.id.pagesValue) }
    private val title: TextView by lazy { findViewById<TextView>(R.id.thumbnail) }
    private val country: TextView by lazy { findViewById<TextView>(R.id.country) }

    init {
        setRootView(inflater.inflate(R.layout.layout_item_book, parent, false))
    }

    override fun bindCategoryDetails(categoryDetailType: CategoryDetailType) {
        // Log.d("Gabriel", "Name of the book: ${(categoryDetailType as CategoryBook).name}")
        //(categoryDetailType as CategoryBook).name}
        pages.text = (categoryDetailType as CategoryBook).numberPages.toString()
        authors.text = categoryDetailType.authors.joinToString { it }
        isbn.text = categoryDetailType.isbn
        title.text = categoryDetailType.name
        country.text = categoryDetailType.country
    }
}