package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.BaseUseCase
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository

class FetchCategoriesUseCase2(private val categoriesNetworkRepository: CategoriesNetworkRepository, private val categoriesRepository: CategoriesUseRepository, asyncTaskManager: AsyncTaskManager) : BaseUseCase(asyncTaskManager) {
    suspend fun execute(): List<Category> = asyncAwait {
        //if(firstRun) {
            categoriesNetworkRepository.getCategories().apply {
                //delay(10000)
                this.forEach { categoriesRepository.insert(it) }
            }
        //}
    }
}