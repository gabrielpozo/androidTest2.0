package com.example.gabrielpozoguzman.androidtest20.screens.common.controllers

import android.support.v7.app.AppCompatActivity
import com.example.gabrielpozoguzman.androidtest20.CustomApplication
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application.ApplicationComponent
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.*

open class BaseActivity : AppCompatActivity() {
    private var mIsInjectorUsed: Boolean = false
    protected fun getPresentationComponent(): PresentationComponent {
        if (mIsInjectorUsed) {
            throw RuntimeException("there is no need to use injector more than once")
        }
        mIsInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as CustomApplication).applicationComponent
    }
}

