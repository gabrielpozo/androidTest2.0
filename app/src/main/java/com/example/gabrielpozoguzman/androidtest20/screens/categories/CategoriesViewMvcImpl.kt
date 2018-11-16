package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.gabrielpozoguzman.androidtest20.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.Category

class CategoriesViewMvcImpl(inflater: LayoutInflater, parent: ViewGroup?) : CategoriesViewMvc, CategoriesRecyclerAdapter.ListenerAdapter {
    private val mRootView: View = inflater.inflate(R.layout.layout_content_frame, parent, false)

    private val mRecyclerQuestions: RecyclerView
    private val mAdapter: CategoriesRecyclerAdapter
    private val mListeners = ArrayList<CategoriesViewMvc.Listener>()

    init {
        mRecyclerQuestions = findViewById(R.id.recycler_questions)
        mRecyclerQuestions.layoutManager = LinearLayoutManager(getContext())
        mAdapter = CategoriesRecyclerAdapter(inflater, this)
        mRecyclerQuestions.adapter = mAdapter
    }

    private fun <T : View> findViewById(id: Int): T {
        return getRootView().findViewById(id)
    }

    private fun getContext(): Context {
        return getRootView().context
    }

    override fun registerLister(listener: CategoriesViewMvc.Listener) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: CategoriesViewMvc.Listener) {
        mListeners.remove(listener)
    }

    override fun getRootView(): View {
        return mRootView
    }

    override fun onCategoryCLicked(category: Category) {
        mListeners.forEach { it.onCategoriesClicked() }

    }

    override fun bindCategories(categories: ArrayList<Category>) {
        mAdapter.bindCategories(categories)
    }
}
