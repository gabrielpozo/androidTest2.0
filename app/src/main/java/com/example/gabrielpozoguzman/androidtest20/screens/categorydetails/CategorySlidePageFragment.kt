package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseFragment
import javax.inject.Inject

class CategorySlidePageFragment : BaseFragment() {
    @Inject
    lateinit var presenter: CategoryDetailsPresenter
    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory

    lateinit var mViewMvc: CategoriesDetailsViewMvc

    companion object {
        private const val FRAGMENT_DETAIL = "fragment_detail_page"
        fun newInstance(categoryDetailEnum: CategoryDetailEnum) = CategorySlidePageFragment().apply {
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
        mViewMvc.categoryId = getCategoryDetailArgument()
        presenter.bindView(mViewMvc)

        return mViewMvc.getRootView()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    private fun getCategoryDetailArgument(): String {
        return arguments?.getString(FRAGMENT_DETAIL) ?: "book"
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }
}

enum class CategoryDetailEnum(val categoryName: String) {
    BOOK("book"), CHARACTER("character"), HOUSE("house")
}