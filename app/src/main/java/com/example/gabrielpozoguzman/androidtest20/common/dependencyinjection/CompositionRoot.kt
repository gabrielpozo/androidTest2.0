package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection

import android.content.Context
import com.example.gabrielpozoguzman.androidtest20.common.Constants
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoriesRoomDatabase
import com.example.gabrielpozoguzman.androidtest20.repository.database.CategoryDao
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CompositionRoot {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(Constants.baseUrl)
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create()).build()

        }
    }

    fun getMobgenApi(): MobgenApi {
        return getRetrofit().create(MobgenApi::class.java)
    }

    fun getCategoriesDao(context: Context): CategoryDao {
        return CategoriesRoomDatabase.getDatabase(context).categoriesDao()
    }
}