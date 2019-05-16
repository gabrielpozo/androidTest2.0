package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import android.support.v4.app.FragmentManager
import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.UseCaseImpl
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesPresenter
import com.example.gabrielpozoguzman.androidtest20.screens.common.dialogs.DialogsManager
import dagger.Module
import dagger.Provides

@Module
class CategoriesModule {
    @Provides
    fun getCategoriesPresenter(fetchCategoriesUseCase: FetchCategoriesUseCase, screensNavigator: ScreensNavigator, coroutinesManager: CoroutinesManager): CategoriesPresenter {
        return CategoriesPresenter(fetchCategoriesUseCase, screensNavigator, coroutinesManager)
    }

    @Provides
    fun getUseCaseImpl(categoriesRepository: CategoriesUseRepository): UseCaseImpl {
        return UseCaseImpl(categoriesRepository)
    }

    @Provides
    fun getDialogsManager(fragmentManager: FragmentManager): DialogsManager {
        return DialogsManager(fragmentManager)
    }
}
