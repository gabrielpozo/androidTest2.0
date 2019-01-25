package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelFactory
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun viewModelFactory(categoriesNetworkRepository: CategoriesNetworkRepository): ViewModelFactory {
        return ViewModelFactory(categoriesNetworkRepository)
    }
}