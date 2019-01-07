package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase2
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    fun getFetchCategoriesUseCase2(categoriesNetworkRepository: CategoriesNetworkRepository, categoriesUseRepository: CategoriesUseRepository, asyncTaskManager: AsyncTaskManager): FetchCategoriesUseCase2 {
        return FetchCategoriesUseCase2(categoriesNetworkRepository, categoriesUseRepository, asyncTaskManager)
    }


}