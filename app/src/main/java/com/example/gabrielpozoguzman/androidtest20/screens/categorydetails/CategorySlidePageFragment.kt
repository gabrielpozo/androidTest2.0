package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseFragment
import javax.inject.Inject

class CategorySlidePageFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    lateinit var mViewMvc: CategoriesDetailsViewMvc
    lateinit var categoryName: CategoryDetailEnum

    private val viewModel by lazy { ViewModelProviders.of(this, viewModelFactory).get(CategoryDetailsViewModel::class.java) }

    companion object {
        private const val FRAGMENT_DETAIL = "fragment_detail_page"
        fun newInstance(categoryDetailEnum: CategoryDetailEnum) = CategorySlidePageFragment().apply {
            categoryName = categoryDetailEnum
            arguments = Bundle().apply { putSerializable(FRAGMENT_DETAIL, categoryDetailEnum.categoryName) }
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            parent: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        getPresentationComponent().inject(this)
        mViewMvc = viewMvcFactory.getCategoryDetailsViewMvc(parent)
        mViewMvc.showProgressIndication()
        viewModel.loadCategoriesDataNow(getCategoryDetailArgument())
        viewModel.categoriesList.observe(this, Observer<PagedList<CategoryDetailType>> { categories ->
            categories?.let {
                mViewMvc.hideProgressIndication()
                mViewMvc.bindCategoriesDetails(it)
            }
        })

        viewModel.getState().observe(this, Observer {

        })

        return mViewMvc.getRootView()
    }

    private fun getCategoryDetailArgument(): String {
        return arguments?.getString(FRAGMENT_DETAIL) ?: "book"
    }
}


enum class CategoryDetailEnum(val categoryName: String) {
    BOOK("book"), CHARACTER("character"), HOUSE("house")
}
