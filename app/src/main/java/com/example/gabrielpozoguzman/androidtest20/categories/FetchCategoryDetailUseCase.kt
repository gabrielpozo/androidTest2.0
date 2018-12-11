package com.example.gabrielpozoguzman.androidtest20.categories

import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.common.BaseUseCase
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import com.example.gabrielpozoguzman.androidtest20.utils.extensions.convertToCategoryDetailModel
import kotlinx.coroutines.delay

class FetchCategoryDetailUseCase(private val categoriesNetworkRepository: CategoriesNetworkRepository, asyncTaskManager: AsyncTaskManager) : BaseUseCase(asyncTaskManager) {

    suspend fun execute(categoryId: String): List<CategoryDetailType> {
        val categoryDetailItem = asyncAwait {
            delay(10000)
            categoriesNetworkRepository.getCategoryDetailsList(categoryId)
        }
        Log.d("Gabriel", "Thread in execute ${Thread.currentThread().name}")
        return categoryDetailItem.convertToCategoryDetailModel(categoryId)
    }

}
