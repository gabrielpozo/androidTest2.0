package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState

data class Result<T>(var resultState: ResultState = ResultState.SUCCESS, var data: T? = null,
                     var networkErrors: Exception? = null) {
}