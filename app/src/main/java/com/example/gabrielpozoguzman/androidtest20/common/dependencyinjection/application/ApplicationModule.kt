package com.example.gabrielpozoguzman.androidtest20.common.dependencyinjection.application

import com.example.gabrielpozoguzman.androidtest20.common.coroutines.*
import com.example.gabrielpozoguzman.androidtest20.common.viewmodel.DefaultCoroutinesViewModel
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
    fun getCoroutinesManagerImpl(): DefaultCoroutinesViewModel {
        return DefaultCoroutinesViewModel()
    }
}