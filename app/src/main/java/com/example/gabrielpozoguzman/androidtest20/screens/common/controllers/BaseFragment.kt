package com.example.gabrielpozoguzman.androidtest20.screens.common.controllers

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.gabrielpozoguzman.androidtest20.CustomApplication
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.ControllerCompositionRoot

open class BaseFragment: Fragment() {

    companion object {
        private fun getControllerCompositionRootInstance(appCustom: CustomApplication, activity: AppCompatActivity): ControllerCompositionRoot {
            return ControllerCompositionRoot(appCustom.mCompositionRoot, activity)
        }
    }

    protected fun getControllerCompositionRoot(): ControllerCompositionRoot {
        return getControllerCompositionRootInstance(requireActivity().application as CustomApplication, requireActivity() as AppCompatActivity)
    }
}