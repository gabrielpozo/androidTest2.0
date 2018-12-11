package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.os.Bundle
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity

class CategoriesActivity : BaseActivity() {
    private lateinit var mViewMvc: CategoriesViewMvc
    private lateinit var presenter: CategoriesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewMvc = getControllerCompositionRoot().getViewMvcFactory().getCategoriesViewMvc(null)
        presenter = getControllerCompositionRoot().getCategoriesPresenter()
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
