package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.util.Log
import android.view.ViewGroup

class CategoriesSlidePageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList = mutableListOf<Fragment>()

    override fun getItem(position: Int): Fragment {
        Log.d("Gabriel", " Who call second? GETITEM() setBackPressedListenerFragment  ${fragmentList[position]}")
        return fragmentList[position]

    }

    override fun getCount(): Int = fragmentList.size

    //Esto es cosa mia
    fun addFragment(fragment: Fragment) {
        //maybe check here if the fragment added is alredy here
        fragmentList.add(fragment)/**
            see how to add these fragments on rotation without calling from the activity
        **/
      //  notifyDataSetChanged()
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // first time(when there is no configuration changes), if there is no fragment at the given position,
        // this method will call getItem(position) method() and the returned fragment will be added to the list* with their respective tag

        //but when there is conf changes this method, instatiateItem, already notices there is a fragment for the given position,
        // therefore it reuses the fragment instead of getting the fragment from the getItem(position)- so it won't call getItem(position)

        // so what we do here is just to assign the recreated fragment(the one we used before that has been recreated after rotation) to the new fragmentList
        // so when we get to call getItem(method) from the activity the method
        // we will get the same instance of the fragment

        var ret = super.instantiateItem(container, position)
        Log.d("Gabriel", " Who call first? 1")

        fragmentList[position] = ret as Fragment
        Log.d("Gabriel", " Who call first interesting?? setBackPressedListenerFragment and position $position $ret")

        return ret
    }
}