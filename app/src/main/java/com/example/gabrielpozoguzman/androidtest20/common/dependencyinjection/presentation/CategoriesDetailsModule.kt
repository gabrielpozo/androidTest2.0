package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoryDetailUseCase
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.CoroutinesManager
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsPresenter
import dagger.Module
import dagger.Provides

@Module
class CategoriesDetailsModule {

    @Provides
    fun getCategoryDetailsPresenter(fetchCategoriesDetailsUseCase: FetchCategoryDetailUseCase, coroutinesManager: CoroutinesManager): CategoryDetailsPresenter {
        return CategoryDetailsPresenter(fetchCategoriesDetailsUseCase, coroutinesManager)
    }

    @Provides
    fun getFetchCategoryDetailUseCase(categoriesNetworkRepository: CategoriesNetworkRepository): FetchCategoryDetailUseCase {
        return FetchCategoryDetailUseCase(categoriesNetworkRepository)
    }

}
