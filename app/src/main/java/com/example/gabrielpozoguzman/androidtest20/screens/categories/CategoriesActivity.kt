package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelFactory
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelImpl
import com.example.gabrielpozoguzman.androidtest20.screens.common.dialogs.DialogsManager
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
import com.example.gabrielpozoguzman.androidtest20.screens.common.dialogs.ServerErrorDialogFragment
import javax.inject.Inject

class CategoriesActivity : BaseActivity(), CategoriesViewMvc.Listener, ServerErrorDialogFragment.Listener {

    private lateinit var mViewMvc: CategoriesViewMvc
    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(ViewModelImpl::class.java) }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory
    @Inject
    lateinit var screensNavigator: ScreensNavigator
    @Inject
    lateinit var mDialogsManager: DialogsManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getPresentationComponent().inject(this)

        mViewMvc = viewMvcFactory.getCategoriesViewMvc(null)

        initViewModelFields()

        setContentView(mViewMvc.getRootView())
    }

    private fun initViewModelFields() {
        viewModel.categories.observe(this, Observer {
            it?.getContentIfNotHandled()?.let { categories ->
                mViewMvc.hideProgressIndication()
                mViewMvc.bindCategories(categories)
            }
        })

        viewModel.networkErrors.observe(this, Observer {
            it?.getContentIfNotHandled()?.let {
                mViewMvc.hideProgressIndication()
                mDialogsManager.showDialogWithId(ServerErrorDialogFragment.newInstance(), "")
            }
        })
    }

    override fun onCategoriesClicked(category: Category) {
        screensNavigator.toCategoriesDetails(category.id)
    }

    override fun onRetryDialogRequest() {
        viewModel.searchCategoriesOnNetwork()
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