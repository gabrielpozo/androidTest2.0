package com.example.gabrielpozoguzman.androidtest20.common


abstract class BaseUseCase<T, U> {
    abstract fun execute(params: U? = null,
                         onSuccess: (T) -> Unit,
                         onError: (String) -> Unit)
}
