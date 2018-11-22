package com.example.gabrielpozoguzman.androidtest20.common

interface BaseObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)
    fun unregisterListener(listener: ListenerType)
}