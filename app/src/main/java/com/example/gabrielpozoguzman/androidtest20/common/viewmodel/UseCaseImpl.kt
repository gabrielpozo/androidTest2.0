package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import java.lang.Exception

class UseCaseImpl(private val mobgenApi: MobgenApi, coroutinesManager: DefaultCoroutines) : BaseUseCase2<Unit?, List<Category>>(coroutinesManager) {

    override suspend fun doInBackground(params: Unit?): Result<List<Category>> {
        val response = mobgenApi.getCategoriesImpl().execute()
        if (response.isSuccessful) {
            return Result(resultState = ResultState.SUCCESS, data = response.body())
        }
        return Result(resultState = ResultState.ERROR, networkErrors = Exception(response.errorBody().toString()))
    }
}