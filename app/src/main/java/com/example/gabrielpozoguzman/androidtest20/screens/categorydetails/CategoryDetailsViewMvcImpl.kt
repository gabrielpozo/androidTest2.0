package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailSchemaItem
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.BaseMvcView
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class CategoryDetailsViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) : BaseMvcView(), CategoriesDetailsViewMvc {

    override lateinit var categoryId: String
    private val mRecyclerQuestions: RecyclerView
    private val mAdapter: CategoriesDetailAdapter
    private val mProgressBar: ProgressBar


    init {
        setRootView(inflater.inflate(R.layout.layout_category_detail_fragment, parent, false))
        mRecyclerQuestions = findViewById(R.id.recycler_questions)
        mProgressBar = findViewById(R.id.progress)
        mRecyclerQuestions.layoutManager = LinearLayoutManager(getContext())
        mAdapter = CategoriesDetailAdapter(inflater, viewMvcFactory)
        mRecyclerQuestions.adapter = mAdapter
    }

    override fun bindCategoriesDetails(categoriesDetailType: List<CategoryDetailType>) {
        mAdapter.bindCategories(categoriesDetailType)
    }

    override fun showProgressIndication() {
        mProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressIndication() {
        mProgressBar.visibility = View.GONE
    }
    override fun showErrorDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}