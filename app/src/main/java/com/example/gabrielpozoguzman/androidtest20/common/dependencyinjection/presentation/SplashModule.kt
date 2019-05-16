package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import com.example.gabrielpozoguzman.androidtest20.categories.CategoriesUseRepository
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase2
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ParameterUseCaseCategories
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    fun getFetchCategoriesUseCase2(parameterUseCaseCategories: ParameterUseCaseCategories, categoriesUseRepository: CategoriesUseRepository): FetchCategoriesUseCase2 {
        return FetchCategoriesUseCase2(parameterUseCaseCategories, categoriesUseRepository)
    }

    @Provides
    fun getParameterUseCaseCategories(categoriesNetworkRepository: CategoriesNetworkRepository): ParameterUseCaseCategories {
        return ParameterUseCaseCategories(categoriesNetworkRepository)
    }
}