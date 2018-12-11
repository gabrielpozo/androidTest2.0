package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class CategoriesSlidePageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList = mutableListOf<Fragment>()

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    fun addFragment(fragment: Fragment) {
        fragmentList.add(fragment)
        notifyDataSetChanged()
    }

}