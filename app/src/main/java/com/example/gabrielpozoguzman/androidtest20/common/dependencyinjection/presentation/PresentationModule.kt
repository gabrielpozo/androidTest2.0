package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(val mActivity: FragmentActivity) {

    @Provides
     fun getFragmentManager(): FragmentManager {
        return mActivity.supportFragmentManager
    }

    @Provides
    fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    @Provides
    fun getViewMvcFactory(layoutInflater: LayoutInflater): ViewMvcFactory {
        return ViewMvcFactory(layoutInflater)
    }

    @Provides
    fun getScreensNavigator(): ScreensNavigator {
        return ScreensNavigator(mActivity)
    }
}