package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.os.Bundle
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.utils.getIntentCategoryDetailValue
import kotlinx.android.synthetic.main.layout_category_detail.*

class CategoryDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_category_detail)

        categoriesViewPager?.let { pager ->
            supportFragmentManager?.let {
                pager.adapter = CategoriesSlidePageAdapter(it).apply {
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.BOOK))
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.HOUSE))
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.CHARACTER))
                }
            }
        }

        val categoryId = getCategoryId()
        setCurrentView(categoryId - 1)

    }


    private fun getCategoryId() = intent.getIntExtra(getIntentCategoryDetailValue(),99)

    private fun setCurrentView(mCurrentItem: Int) {
        categoriesViewPager.currentItem = mCurrentItem
    }
}