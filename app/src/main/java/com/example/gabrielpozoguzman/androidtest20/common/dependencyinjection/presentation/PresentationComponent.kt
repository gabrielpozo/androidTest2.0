package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesActivity
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategorySlidePageFragment
import com.example.gabrielpozoguzman.androidtest20.screens.splash.SplashActivity
import dagger.Subcomponent

@Subcomponent(modules = [PresentationModule::class, CategoriesModule::class, CategoriesDetailsModule::class, SplashModule::class, ViewModelModule::class])
interface PresentationComponent {

    fun inject(categories: SplashActivity)
    fun inject(categories: CategoriesActivity)
    fun inject(categoriesDetails: CategorySlidePageFragment)
}

