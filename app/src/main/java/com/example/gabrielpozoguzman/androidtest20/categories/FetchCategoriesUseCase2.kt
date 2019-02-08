package com.example.gabrielpozoguzman.androidtest20.categories

import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.BaseUseCase2
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.DefaultCoroutines
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.Result
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import java.lang.Exception

class FetchCategoriesUseCase2(val mobgenApi: MobgenApi, private val categoriesRepository: CategoriesUseRepository, defaultCoroutines: DefaultCoroutines)
    : BaseUseCase2<Unit, List<Category>>(defaultCoroutines) {

    override suspend fun doInBackground(params: Unit?): Result<List<Category>> {
        val response = mobgenApi.getCategoriesImpl().execute()
        if (response.isSuccessful) {
            response.body()?.forEach {
                categoriesRepository.insert(it)
            }
            return Result(resultState = ResultState.SUCCESS, data = response.body())
        }
        return Result(resultState = ResultState.ERROR, networkErrors = Exception(response.errorBody().toString()))

    }

}