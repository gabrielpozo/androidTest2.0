package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.presentation

import android.arch.lifecycle.ViewModel
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.UseCaseImpl
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelFactory
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ViewModelImpl
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsActivity
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)


    @Provides
    fun viewModelFactory(providerMap: MutableMap<Class<out ViewModel>, Provider<ViewModel>>): ViewModelFactory {
        return ViewModelFactory(providerMap)
    }

    @Provides
    @IntoMap
    @ViewModelKey(ViewModelImpl::class)
    fun categoriesViewModel(useCaseImpl: UseCaseImpl): ViewModel {
        return ViewModelImpl(useCaseImpl)
    }

    @Provides
    @IntoMap
    @ViewModelKey(CategoryDetailsViewModel::class)
    fun categoriesDetailViewModel(categoriesNetworkRepository: CategoriesNetworkRepository, categoriesBackPressedDispatcher: CategoryDetailsActivity): ViewModel {
        return CategoryDetailsViewModel(categoriesNetworkRepository, categoriesBackPressedDispatcher)
    }
}