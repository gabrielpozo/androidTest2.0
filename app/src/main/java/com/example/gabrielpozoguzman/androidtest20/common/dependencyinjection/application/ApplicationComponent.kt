package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.CategoriesDetailsModule
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.PresentationComponent
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.CategoriesModule
import com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation.SplashModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, ApplicationDatabaseModule::class, ApplicationNetworkingModule::class))
interface ApplicationComponent {
    fun newPresentationComponent(categoriesModule: CategoriesModule, categoriesDetailsModule: CategoriesDetailsModule, splashModule: SplashModule): PresentationComponent
}