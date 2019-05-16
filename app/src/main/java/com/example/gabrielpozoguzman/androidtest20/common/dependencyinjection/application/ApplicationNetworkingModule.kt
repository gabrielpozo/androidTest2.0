package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import com.example.gabrielpozoguzman.androidtest20.common.Constants
import com.example.gabrielpozoguzman.androidtest20.networking.MobgenApi
import com.example.gabrielpozoguzman.androidtest20.repositories.CategoriesNetworkRepository
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationNetworkingModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.baseUrl)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getMobgenApi(retrofit: Retrofit): MobgenApi {
        return retrofit.create(MobgenApi::class.java)
    }

    @Provides
    fun getCategoriesNetworkRepository(mobgenApi: MobgenApi): CategoriesNetworkRepository {
        return CategoriesNetworkRepository(mobgenApi)
    }

}
