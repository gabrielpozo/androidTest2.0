package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase2
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.screens.categories.CategoriesPresenter
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsPresenter
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoryDetailUseCase
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoryDao
import com.example.gabrielpozoguzman.androidtest20.screens.common.ViewMvcFactory

class ControllerCompositionRoot(private val mCompositionRoot: CompositionRoot, private val mActivity: Activity) {


    private fun getMobgenApi(): MobgenApi {
        return mCompositionRoot.getMobgenApi()
    }

    private fun getLayoutInflater(): LayoutInflater {
        return LayoutInflater.from(mActivity)
    }

    private fun getContext(): Context {
        return mActivity
    }

    fun getViewMvcFactory(): ViewMvcFactory {
        return ViewMvcFactory(getLayoutInflater()) //return getCategoryListItemViewMvcImpl --> CategoryListItemViewMvcImpl(mLayoutInflater, parent, navigationDrawer, getImageLoader())
    }

    fun getCategoriesPresenter(): CategoriesPresenter {
        return CategoriesPresenter(getFetchCategoriesUseCase(), getScreensNavigator(), getCoroutinesManager())
    }

    fun getCategoryDetailsPresenter(): CategoryDetailsPresenter {
        return CategoryDetailsPresenter(getFetchCategoryDetailUseCase(), getCoroutinesManager())
    }

    fun getFetchCategoriesUseCase2(): FetchCategoriesUseCase2 {
        return FetchCategoriesUseCase2(getCategoriesNetworkRepository(), CategoriesUseRepository(getCategoriesDao()), getAsyncTaskManager())
    }

    private fun getFetchCategoriesUseCase(): FetchCategoriesUseCase {
        return FetchCategoriesUseCase(getMobgenApi())
    }

    private fun getFetchCategoryDetailUseCase(): FetchCategoryDetailUseCase {
        return FetchCategoryDetailUseCase(getCategoriesNetworkRepository(), getAsyncTaskManager())
    }

    private fun getCategoriesNetworkRepository(): CategoriesNetworkRepository {
        return CategoriesNetworkRepository(getMobgenApi())
    }

    private fun getCategoriesDao(): CategoryDao {
        return mCompositionRoot.getCategoriesDao(getContext())
    }

    private fun getScreensNavigator(): ScreensNavigator {
        return ScreensNavigator(getContext())
    }

    private fun getCoroutinesManager(): CoroutinesManager {
        return DefaultCoroutinesManager()
    }

    private fun getAsyncTaskManager(): AsyncTaskManager {
        return DefaultAsyncTasksManager()
    }

    private fun getCoroutineScope(): CoroutineScopeCategoryDetails {
        return CoroutineScopeCategoryDetails()
    }

}