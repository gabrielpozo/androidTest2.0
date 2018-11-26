package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.os.Bundle
import com.example.gabrielpozoguzman.androidtest20.screens.common.BaseActivity
import android.support.v4.view.ViewPager
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.R


class CategoryDetailsActivity : BaseActivity() {

    private lateinit var mViewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.layout_category_detail)

        mViewPager = findViewById(R.id.viewpager)

        mViewPager.adapter = CategoriesSlidePageAdapter(supportFragmentManager)

        //Temporary Fragment
        mViewPager.currentItem = 1

    }

}