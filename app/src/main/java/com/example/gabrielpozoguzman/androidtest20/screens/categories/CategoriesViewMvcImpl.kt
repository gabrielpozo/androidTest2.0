package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.BaseObservable
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class CategoriesViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?, viewMvcFactory: ViewMvcFactory) : BaseObservable<CategoriesViewMvc.Listener>(), CategoriesViewMvc, CategoriesRecyclerAdapter.ListenerAdapter {

    private val mRecyclerQuestions: RecyclerView
    private val mAdapter: CategoriesRecyclerAdapter
    private val mProgressBar: ProgressBar

    init {
        setRootView(inflater.inflate(R.layout.layout_content_frame, parent, false))
        mRecyclerQuestions = findViewById(R.id.recycler_questions)
        mProgressBar = findViewById(R.id.progress)
        mRecyclerQuestions.layoutManager = LinearLayoutManager(getContext())
        mAdapter = CategoriesRecyclerAdapter(inflater, this, viewMvcFactory)
        mRecyclerQuestions.adapter = mAdapter
    }

    override fun onCategoryCLicked(category: Category) {
        listeners.forEach {
            it.onCategoriesClicked() }
    }

    override fun bindCategories(categories: List<Category>) {
        mAdapter.bindCategories(categories)
    }

    override fun showProgressIndication() {
        mProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressIndication() {
        mProgressBar.visibility = View.GONE
    }
}
