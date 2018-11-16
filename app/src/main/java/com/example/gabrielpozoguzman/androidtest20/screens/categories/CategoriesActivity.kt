package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.os.Bundle
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.common.Constants
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.screens.common.BaseActivity
import com.techyourchance.mvc.networking.questions.CategoriesSchema
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriesActivity : BaseActivity(), CategoriesViewMvc.Listener {
    lateinit var mobgenApi: MobgenApi

    lateinit var mViewMvc: CategoriesViewMvc
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewMvc = CategoriesViewMvcImpl(LayoutInflater.from(this), null)
        mViewMvc.registerLister(this)

        mobgenApi = Retrofit.Builder().baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MobgenApi::class.java)

        setContentView(mViewMvc.getRootView())
    }

    override fun onStart() {
        super.onStart()
        fetchCategories()
    }

    private fun fetchCategories() {
        mobgenApi.getCategories()
                .enqueue(object : Callback<List<CategoriesSchema>> {
                    override fun onResponse(call: Call<List<CategoriesSchema>>, response: Response<List<CategoriesSchema>>) {
                        if (response.isSuccessful()) {
                            bindCategories(response.body()!!)

                        } else {
                            networkCallFailed()
                        }
                    }

                    override fun onFailure(call: Call<List<CategoriesSchema>>, t: Throwable) {
                        networkCallFailed()
                    }
                })
    }

    private fun bindCategories(categoriesSchema: List<CategoriesSchema>) {
        val categories = ArrayList<Category>()
        categoriesSchema.forEach {
            categories.add(Category(it.id, it.title, it.href))
        }
        mViewMvc.bindCategories(categories)
    }

    private fun networkCallFailed() {

    }

    override fun onCategoriesClicked() {

    }
}