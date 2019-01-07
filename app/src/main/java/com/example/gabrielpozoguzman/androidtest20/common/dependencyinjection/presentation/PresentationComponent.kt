package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesActivity
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoriesSlidePageAdapter
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsActivity
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategorySlidePageFragment
import com.example.gabrielpozoguzman.androidtest20.screens.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(CategoriesModule::class, CategoriesDetailsModule::class, SplashModule::class))
interface PresentationComponent {
    fun inject(categories: SplashActivity)
    fun inject(categories: CategoriesActivity)
    fun inject(categoriesdetails: CategorySlidePageFragment)
}