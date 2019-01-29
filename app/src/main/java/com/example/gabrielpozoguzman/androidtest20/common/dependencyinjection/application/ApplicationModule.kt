package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.DefaultCoroutines
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

    @Provides
    fun getCoroutinesManagerImpl(): DefaultCoroutines {
        return DefaultCoroutines()
    }
}