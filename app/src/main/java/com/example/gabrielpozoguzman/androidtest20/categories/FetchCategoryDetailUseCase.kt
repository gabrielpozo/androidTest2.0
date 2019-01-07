package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.BaseUseCase
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.utils.extensions.convertToCategoryDetailModel

class FetchCategoryDetailUseCase(private val categoriesNetworkRepository: CategoriesNetworkRepository, asyncTaskManager: AsyncTaskManager) : BaseUseCase(asyncTaskManager) {

    suspend fun execute(categoryId: String): List<CategoryDetailType> = asyncAwait {
        categoriesNetworkRepository.getCategoryDetailsList(categoryId)
    }.convertToCategoryDetailModel(categoryId)

}


