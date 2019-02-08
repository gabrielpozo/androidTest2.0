package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.common.pagelist.ResultState

data class Result<T>(var resultState: ResultState, var data: T? = null,
                     var networkErrors: Exception = Exception("Exception not define")) {
}