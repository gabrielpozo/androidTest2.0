package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelFactory
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelImpl
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsViewModel
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
import javax.inject.Inject

class CategoriesActivity : BaseActivity(), CategoriesViewMvc.Listener {

    private lateinit var mViewMvc: CategoriesViewMvc
    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(ViewModelImpl::class.java) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory
    @Inject
    lateinit var screensNavigator: ScreensNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)

        mViewMvc = viewMvcFactory.getCategoriesViewMvc(null)

        viewModel.categories.observe(this, Observer {
            it?.getContentIfNotHandled()?.let { categories ->
                mViewMvc.hideProgressIndication()
                mViewMvc.bindCategories(categories)
            }
        })

        viewModel.networkErrors.observe(this, Observer {
            it?.getContentIfNotHandled()?.let {

            }
        })
        setContentView(mViewMvc.getRootView())
    }

    override fun onCategoriesClicked(category: Category) {
        screensNavigator.toCategoriesDetails(category.id)
    }


    override fun onStart() {
        super.onStart()
        mViewMvc.registerListener(this)
        mViewMvc.showProgressIndication()
        viewModel.searchCategoriesOnNetwork()

    }

    override fun onStop() {
        super.onStop()
        mViewMvc.unregisterListener(this)
    }

}