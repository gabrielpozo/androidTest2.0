package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BaseActivity
import com.example.gabrielpozoguzman.androidtest20.R
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedDispatcher
import com.example.gabrielpozoguzman.androidtest20.screens.common.controllers.BackPressedListener
import com.example.gabrielpozoguzman.androidtest20.utils.getIntentCategoryDetailValue
import kotlinx.android.synthetic.main.layout_category_detail.*

class CategoryDetailsActivity : BaseActivity(), BackPressedDispatcher {
    private lateinit var mBackPressedListener: BackPressedListener

    private val mBackPressedListeners = mutableSetOf<BackPressedListener>()
    private val categoryIdItem = "CategoryId"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_category_detail)

        categoriesViewPager?.let { viewPager ->
            supportFragmentManager?.let {
                viewPager.adapter = CategoriesSlidePageAdapter(it).apply {
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.BOOK))
                    Log.d("GabrielS", "setBackPressedListenerFragment CALLNG IN ADDFRGMENT")
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.HOUSE))
                    addFragment(CategorySlidePageFragment.newInstance(CategoryDetailEnum.CHARACTER))
                }
            }
        }

        val currentView = savedInstanceState?.let {
            it.getInt(categoryIdItem)
        } ?: getCategoryId() - 1

        setCurrentView(currentView)
        // setBackPressedListenerToFragment(currentView)
        addListenerToViewPager()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt(categoryIdItem, categoriesViewPager.currentItem)
    }

    private fun getCategoryId() = intent.getIntExtra(getIntentCategoryDetailValue(), 99)

    private fun addListenerToViewPager() {
        //  categoriesViewPager?.addOnPageChangeListener(ViewPagerOnPageSelected(this::setBackPressedListenerToFragment))
    }

    private fun setBackPressedListenerToFragment(position: Int) {
        categoriesViewPager.post {
            val adapter = categoriesViewPager.adapter as CategoriesSlidePageAdapter
            val fragment = adapter.getItem(position) as CategorySlidePageFragment
            Log.d("GabrielS", "setBackPressedListenerFragment 2 LASST?? $fragment")
            // mBackPressedListener = fragment
        }
    }

    private fun setCurrentView(mCurrentItem: Int) {
        categoriesViewPager.currentItem = mCurrentItem
    }

    override fun onBackPressed() {
        super.onBackPressed()
        var isBackPressedConsumedByAnyListener = false
        mBackPressedListeners.forEach {
            if (it.onBackPressed()) {
                isBackPressedConsumedByAnyListener = true
            }
        }

        if (!isBackPressedConsumedByAnyListener) super.onBackPressed()
    }

    override fun registerListener(listener: BackPressedListener) {
        mBackPressedListeners.add(listener)
    }

    override fun unRegisterListener(listener: BackPressedListener) {
        mBackPressedListeners.remove(listener)
    }

    // ViewPagerOnPageSelected.kt
    class ViewPagerOnPageSelected(private val setListenerToFragment: (Int) -> Unit = {}) : ViewPager.OnPageChangeListener {
        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }

        override fun onPageSelected(position: Int) {
            setListenerToFragment(position)
        }

        override fun onPageScrollStateChanged(state: Int) {
        }
    }

}
