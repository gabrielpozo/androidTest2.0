package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.os.Bundle
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
import javax.inject.Inject

class CategoriesActivity : BaseActivity() {
    private lateinit var mViewMvc: CategoriesViewMvc

    @Inject
    lateinit var presenter: CategoriesPresenter
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)

        mViewMvc = viewMvcFactory.getCategoriesViewMvc(null)
        presenter.bindView(mViewMvc)

        setContentView(mViewMvc.getRootView())
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

}
