package com.example.gabrielpozoguzman.androidtest20.networking

import com.example.gabrielpozoguzman.androidtest20.common.Constants
import com.techyourchance.mvc.networking.questions.CategoriesSchema
import retrofit2.Call
import retrofit2.http.GET


interface MobgenApi{
    @GET(Constants.categories)
    fun getCategories(): Call<List<CategoriesSchema>>

}