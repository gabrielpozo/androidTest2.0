package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class CategoriesSlidePageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment = CategorySlidePageFragment()

    override fun getCount(): Int = 3

}