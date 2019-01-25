package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import com.example.gabrielpozoguzman.androidtest20.repository.CategoriesNetworkRepository
import java.lang.Exception

class UseCaseImpl(val categoriesNetworkRepository: CategoriesNetworkRepository, coroutinesManager: DefaultCoroutines) : BaseUseCase2<Unit?, List<Category>>(coroutinesManager) {

    override fun doInBackground(params: Unit?): Result<List<Category>> {
        lateinit var result: Result<List<Category>>
        categoriesNetworkRepository.getCategoriesImpl({ categories ->
            result = Result(resultState = ResultState.SUCCESS, data = categories)
        }, {
            result = Result(resultState = ResultState.ERROR, networkErrors = Exception(""))
        })
        return result
    }
}