package com.example.gabrielpozoguzman.androidtest20.common

interface BaseObservableViewMvc<ListenerType> : ViewMvc {

    fun registerLister(listener: ListenerType)
    fun unregisterListener(listener: ListenerType)
}