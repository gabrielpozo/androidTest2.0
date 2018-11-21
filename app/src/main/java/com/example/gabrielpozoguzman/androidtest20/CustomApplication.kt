package com.example.gabrielpozoguzman.androidtest20

import android.app.Application
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.CompositionRoot

class CustomApplication : Application() {

    lateinit var mCompositionRoot: CompositionRoot
        private set

    override fun onCreate() {
        super.onCreate()
        mCompositionRoot = CompositionRoot()
    }


}