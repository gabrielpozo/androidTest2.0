package com.example.gabrielpozoguzman.androidtest20

import android.app.Application
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application.ApplicationComponent
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application.ApplicationDatabaseModule
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application.DaggerApplicationComponent

class CustomApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent
        private set


    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationDatabaseModule(ApplicationDatabaseModule(this)).build()

    }

}