package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.BaseUseCase
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.CoroutinesManager
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository

class FetchCategoriesUseCase2(private val categoriesNetworkRepository: CategoriesNetworkRepository, private val categoriesRepository: CategoriesUseRepository, coroutinesManager: CoroutinesManager)
                                                                    : BaseUseCase<List<Category>, String>(), CoroutinesManager by coroutinesManager {
    override fun execute(params: String?, onSuccess: (List<Category>) -> Unit, onError: (String) -> Unit) {
        launchOnUITryCatch({
            categoriesNetworkRepository.getCategories().apply {
                this.forEach { categoriesRepository.insert(it) }
                onSuccess(this)
            }
        }, {
            onError("this")
        })

    }
}