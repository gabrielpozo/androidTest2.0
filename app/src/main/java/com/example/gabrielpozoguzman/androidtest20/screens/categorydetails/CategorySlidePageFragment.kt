package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.categories.CategoryDetailType
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedDispatcher
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedListener
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseFragment
import javax.inject.Inject

class CategorySlidePageFragment : BaseFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var viewMvcFactory: ViewMvcFactory
/*    @Inject
    lateinit var mBackPressedDispatcher: BackPressedDispatcher*/

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

        viewModel.loadCategoriesDataNow(getCategoryDetailArgument())
        Log.d("GabrielS", "let's see whats the value of the viewModel or this on BackPressed $this")

        viewModel.categoriesList.observe(this, Observer<PagedList<CategoryDetailType>> { categories ->
            categories?.let {
                mViewMvc.bindCategoriesDetails(it)
            }
        })

        viewModel.getState().observe(this, Observer {

        })

        return mViewMvc.getRootView()
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

    override fun onStop() {
        super.onStop()
        viewModel.onStop()
    }

    private fun getCategoryDetailArgument(): String {
        return arguments?.getString(FRAGMENT_DETAIL) ?: "book"
    }
}

enum class CategoryDetailEnum(val categoryName: String) {
    BOOK("book"), CHARACTER("character"), HOUSE("house")
}
