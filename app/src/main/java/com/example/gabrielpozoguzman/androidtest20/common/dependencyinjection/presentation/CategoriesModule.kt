package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import android.support.v4.app.FragmentManager
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.DefaultCoroutines
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.UseCaseImpl
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
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
    fun getUseCaseImpl(mobgenApi: MobgenApi, coroutines: DefaultCoroutines): UseCaseImpl {
        return UseCaseImpl(mobgenApi, coroutines)
    }

    @Provides
    fun getDialogsManager(fragmentManager: FragmentManager): DialogsManager {
        return DialogsManager(fragmentManager)
    }
}
