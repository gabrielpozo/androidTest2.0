package com.example.gabrielpozoguzman.androidtest20.networking

import com.example.gabrielpozoguzman.androidtest20.categories.*
import com.example.gabrielpozoguzman.androidtest20.common.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Call

import retrofit2.http.GET

interface MobgenApi {
    @GET(Constants.categories)
    fun getCategories(): Call<List<Category>>

    @GET(Constants.categories)
    fun getCategories2(): Deferred<List<Category>>

    @GET(Constants.categoriesBook)
    fun getCategoryListBook(): Deferred<List<CategorySchemaBook>>

    @GET(Constants.categoriesHouse)
    fun getCategoryListHouse(): Deferred<List<CategorySchemaHouse>>

    @GET(Constants.categoriesCharacter)
    fun getCategoryListCharacter(): Deferred<List<CategorySchemaCharacter>>

}