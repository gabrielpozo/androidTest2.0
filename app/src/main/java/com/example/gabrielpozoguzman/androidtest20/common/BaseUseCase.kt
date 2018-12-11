package com.example.gabrielpozoguzman.androidtest20.common

import com.example.gabrielpozoguzman.androidtest20.common.coroutines.AsyncTaskManager

open class BaseUseCase(asyncTaskManager: AsyncTaskManager) : AsyncTaskManager by asyncTaskManager {


}