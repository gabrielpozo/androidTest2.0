package com.example.gabrielpozoguzman.androidtest20.common.viewmodel

import com.example.gabrielpozoguzman.androidtest20.common.interfaces.ParameterUseCase
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCaseRx<T, R> {

    var disposables: CompositeDisposable = CompositeDisposable()
    fun executeUseCase(consumer: Consumer<R>, consumerError: Consumer<Throwable>, parameterUseCase: ParameterUseCase<T>) {
        disposables.add(
                parameterUseCase.executeAction()
                        .subscribeOn(Schedulers.io())
                        .compose(processDataStream())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(consumer, consumerError)
        )

    }

    abstract fun processDataStream(): ObservableTransformer<T, R>
}