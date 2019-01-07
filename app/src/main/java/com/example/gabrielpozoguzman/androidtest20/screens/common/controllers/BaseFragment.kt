package com.example.gabrielpozoguzman.androidtest20.screens.common.controllers

import android.support.v4.app.Fragment
import com.example.gabrielpozoguzman.androidtest20.CustomApplication
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application.ApplicationComponent
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.CategoriesDetailsModule
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.CategoriesModule
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.PresentationComponent
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.SplashModule

open class BaseFragment: Fragment() {

    protected fun getPresentationComponent(): PresentationComponent {
        return getApplicationComponent().
                newPresentationComponent(CategoriesModule(activity!!), CategoriesDetailsModule(), SplashModule())
    }

    protected fun getApplicationComponent(): ApplicationComponent {
        return (activity?.application as CustomApplication).applicationComponent
    }
}