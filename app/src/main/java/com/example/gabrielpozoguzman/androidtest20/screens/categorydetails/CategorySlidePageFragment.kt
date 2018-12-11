package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseFragment

class CategorySlidePageFragment : BaseFragment() {

    lateinit var presenter: CategoryDetailsPresenter
    lateinit var mViewMvc: CategoriesDetailsViewMvc

    companion object {
        private const val FRAGMENT_DETAIL = "fragment_detail_page"
        fun newInstance(categoryDetailEnum: CategoryDetailEnum) = CategorySlidePageFragment().apply {
            arguments = Bundle().apply { putSerializable(FRAGMENT_DETAIL, categoryDetailEnum) }
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            parent: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        presenter = getControllerCompositionRoot().getCategoryDetailsPresenter()
        mViewMvc = getControllerCompositionRoot().getViewMvcFactory().getCategoryDetailsViewMvc(parent)
        mViewMvc.categoryId = "book"
        presenter.bindView(mViewMvc)

        return mViewMvc.getRootView()
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

enum class CategoryDetailEnum {
    FIRST, SECOND, THIRD
}