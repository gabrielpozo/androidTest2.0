package com.example.gabrielpozoguzman.androidtest20.networking

import com.example.gabrielpozoguzman.androidtest20.categories.CategoryBook

interface InfoResponse<T, RESPONSE> {
    var status: Status
    var successType: RESPONSE

}

data class CategoryBookInfoResponse(override var status: Status = Status.SUCCESS, override var successType: List<CategoryBook> = ArrayList()) : InfoResponse<CategoryBookInfoResponse, List<CategoryBook>> {
}

enum class Status {
    SUCCESS, ERROR, ERROR_EXCEPTION
}