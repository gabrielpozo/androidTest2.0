package com.example.gabrielpozoguzman.androidtest20.screens.common.controllers

import android.support.v4.app.Fragment
import com.example.gabrielpozoguzman.androidtest20.CustomApplication
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application.ApplicationComponent
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.*

open class BaseFragment : Fragment() {

    protected fun getPresentationComponent(): PresentationComponent {
        return getApplicationComponent().newPresentationComponent(PresentationModule(activity!!))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (activity?.application as CustomApplication).applicationComponent
    }
}