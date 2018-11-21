package com.example.gabrielpozoguzman.androidtest20.screens.common

import android.support.v7.app.AppCompatActivity
import com.example.gabrielpozoguzman.androidtest20.CustomApplication
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.ControllerCompositionRoot

open class BaseActivity : AppCompatActivity() {
    companion object {
        private fun getControllerCompositionRootInstance(appCustom: CustomApplication, activity: AppCompatActivity): ControllerCompositionRoot {
            return ControllerCompositionRoot(appCustom.mCompositionRoot, activity)
        }
    }

    protected fun getControllerCompositionRoot(): ControllerCompositionRoot {
        return getControllerCompositionRootInstance(application as CustomApplication, this)
    }
}

