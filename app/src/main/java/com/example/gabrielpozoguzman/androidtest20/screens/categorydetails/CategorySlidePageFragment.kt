package com.example.gabrielpozoguzman.androidtest20.screens.categorydetails

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gabrielpozoguzman.androidtest20.R

class CategorySlidePageFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_category_slide_page, container, false)
}