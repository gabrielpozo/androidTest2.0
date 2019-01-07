package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import android.content.Context
import com.example.gabrielpozoguzman.androidtest20.common.ScreensNavigator
import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

  /*  @Provides
    fun getScreensNavigator(context: Context): ScreensNavigator {
        return ScreensNavigator(context)
    }*/

    @Provides
    fun getAsyncTaskManager(): AsyncTaskManager {
        return DefaultAsyncTasksManager()
    }

    @Provides
    fun getCoroutineScope(): CoroutineScopeCategoryDetails {
        return CoroutineScopeCategoryDetails()
    }

    @Provides
    fun getCoroutinesManager(): CoroutinesManager {
        return DefaultCoroutinesManager()
    }

}