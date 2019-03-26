package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import java.lang.Exception

class UseCaseImpl2(val mobgenApiMock: MobgenApi) {
    fun fetchCategories(response: (Result<List<Category>>) -> Unit) {
        var response = mobgenApiMock.getCategories().execute()
        if (response.isSuccessful) {
            response(Result(ResultState.SUCCESS, response.body()))
        } else {
            when (response.code()) {
                500 -> response(Result(ResultState.NETWORK_ERROR, networkErrors = Exception(response.body().toString())))
                else -> response(Result(ResultState.ERROR, networkErrors = Exception(response.body().toString())))
            }
        }
    }
}