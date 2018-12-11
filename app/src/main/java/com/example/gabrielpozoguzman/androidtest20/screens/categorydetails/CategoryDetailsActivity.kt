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
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.FIRST))
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.SECOND))
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.THIRD))
                }
            }
        }

        //val categoryId = getCategoryId()

        //setCurrentView(categoryId.toInt() - 1)

    }

    private fun getCategoryId() = intent.getStringExtra(getIntentCategoryDetailValue())

    private fun setCurrentView(mCurrentItem: Int) {
        categoriesViewPager.currentItem = mCurrentItem
    }
}