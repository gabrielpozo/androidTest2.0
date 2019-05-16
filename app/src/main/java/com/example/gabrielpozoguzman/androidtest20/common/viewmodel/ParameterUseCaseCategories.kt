package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.interfaces.ParameterUseCase
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository
import io.reactivex.Observable

class ParameterUseCaseCategories(private val categoriesNetworkRepository: CategoriesNetworkRepository) : ParameterUseCase<List<Category>> {
    override fun executeAction(): Observable<List<Category>> {
        return categoriesNetworkRepository.getCategories()
    }
}