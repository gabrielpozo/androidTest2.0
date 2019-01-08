package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import android.content.Context
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesPresenter
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory
import dagger.Module
import dagger.Provides

@Module
class CategoriesModule(val mActivity: Context) {

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

    @Provides
    fun getCategoriesPresenter(fetchCategoriesUseCase: FetchCategoriesUseCase, screensNavigator: ScreensNavigator, coroutinesManager: CoroutinesManager): CategoriesPresenter {
        return CategoriesPresenter(fetchCategoriesUseCase, screensNavigator, coroutinesManager)
    }

    @Provides
    fun getFetchCategoriesUseCase(mobgenApi: MobgenApi): FetchCategoriesUseCase {
        return FetchCategoriesUseCase(mobgenApi)
    }

}
