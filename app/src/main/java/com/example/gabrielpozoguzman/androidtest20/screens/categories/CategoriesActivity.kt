package com.example.gabrielpozoguzman.androidtest20.screens.categories

import android.os.Bundle
import android.view.LayoutInflater
import com.example.gabrielpozoguzman.androidtest20.categories.Category
import com.example.gabrielpozoguzman.androidtest20.categories.FetchCategoriesUseCase
import com.example.gabrielpozoguzman.androidtest20.common.Constants
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.screens.common.BaseActivity
import com.techyourchance.mvc.networking.questions.CategoriesSchema
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CategoriesActivity : BaseActivity() {
    private lateinit var mViewMvc: CategoriesViewMvc
    private lateinit var presenter: CategoriesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewMvc = getControllerCompositionRoot().getViewMvcFactory().getCategoriesViewMvc(null)
        presenter = getControllerCompositionRoot().getCategoriesPresenter()
        presenter.bindView(mViewMvc)

        setContentView(mViewMvc.getRootView())
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

}
