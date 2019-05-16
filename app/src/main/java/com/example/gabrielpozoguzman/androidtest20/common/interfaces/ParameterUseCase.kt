package com.example.gabrielpozoguzman.androidtest20.common.interfaces

import io.reactivex.Observable

interface ParameterUseCase<R> {
    fun executeAction(): Observable<R>
}