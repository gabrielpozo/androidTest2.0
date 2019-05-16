package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.BaseUseCase
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository

class FetchCategoryDetailUseCase(private val categoriesNetworkRepository: CategoriesNetworkRepository) : BaseUseCase<List<CategoryDetailType>, String>() {
    override fun execute(params: String?, onSuccess: (List<CategoryDetailType>) -> Unit, onError: (String) -> Unit) {
   /*     params?.let { id ->
            categoriesNetworkRepository.getCategoryDetailsList(id, {
                onSuccess(it.convertToCategoryDetailModel(id))
            }, {
                onError(it)
            })
        }*/
    }
}
