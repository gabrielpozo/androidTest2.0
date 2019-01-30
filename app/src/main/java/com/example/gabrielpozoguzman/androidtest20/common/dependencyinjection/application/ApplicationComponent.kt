package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ApplicationDatabaseModule::class, ApplicationNetworkingModule::class])
interface ApplicationComponent {
    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
}