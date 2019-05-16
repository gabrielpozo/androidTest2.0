package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.BaseUseCaseRx
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.ParameterUseCaseCategories
import io.reactivex.*
import io.reactivex.functions.Consumer

class FetchCategoriesUseCase2(private val parameterUseCaseCategories: ParameterUseCaseCategories, private val categoriesUseRepository: CategoriesUseRepository) : BaseUseCaseRx<List<Category>, List<Category>>() {


    fun fetchCategories(consumer: () -> Unit, consumerError: (t: Throwable) -> Unit) {
        executeUseCase(Consumer {
            consumer.invoke()
        }, Consumer {
            consumerError.invoke(it)
        }, parameterUseCaseCategories)
    }

    override fun processDataStream(): ObservableTransformer<List<Category>, List<Category>> {
        return ObservableTransformer { upstream ->
            upstream.map { categories ->
                categories.forEach {
                    categoriesUseRepository.insert(it)
                }
                categories
            }
        }

    }
}