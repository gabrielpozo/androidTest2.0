package com.example.gabrielpozoguzman.androidtest20.networking

import com.example.gabrielpozoguzman.androidtest20.categories.*
import com.example.gabrielpozoguzman.androidtest20.common.Constants
import kotlinx.coroutines.Deferred
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface MobgenApi {
    @GET(Constants.categories)
    fun getCategories(): Call<List<Category>>

    @GET(Constants.categories)
    fun getCategoriesImpl(): Call<List<Category>>

    @GET(Constants.categoriesBook)
    fun getCategoryListBook(@Query("_page") page: String, @Query("_limit") limit: String): Call<List<CategorySchemaBook>>

    @GET(Constants.categoriesHouse)
    fun getCategoryListHouse(@Query("_page") page: String, @Query("_limit") limit: String): Call<List<CategorySchemaHouse>>

    @GET(Constants.categoriesCharacter)
    fun getCategoryListCharacter(@Query("_page") page: String, @Query("_limit") limit: String): Call<List<CategorySchemaCharacter>>
}