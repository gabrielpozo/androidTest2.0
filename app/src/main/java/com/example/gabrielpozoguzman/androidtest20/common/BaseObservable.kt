package com.example.gabrielpozoguzman.androidtest20.common

import java.util.*
import java.util.concurrent.ConcurrentHashMap

abstract class BaseObservable<LISTENER_CLASS> : BaseMvcView(), BaseObservableViewMvc<LISTENER_CLASS> {

    // thread-safe set of listeners
    private val mListeners = Collections.newSetFromMap(
            ConcurrentHashMap<LISTENER_CLASS, Boolean>(1))

    protected val listeners: Set<LISTENER_CLASS>
        get() = Collections.unmodifiableSet(mListeners)


    override fun registerListener(listener: LISTENER_CLASS) {
        mListeners.add(listener)
    }

    override fun unregisterListener(listener: LISTENER_CLASS) {
        mListeners.remove(listener)
    }

}