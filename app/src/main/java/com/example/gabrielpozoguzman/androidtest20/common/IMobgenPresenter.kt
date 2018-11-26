package com.example.gabrielpozoguzman.androidtest20.common

interface IMobgenPresenter<ViewMvcType> {
    fun onStart()
    fun onStop()
    fun bindView(listener: ViewMvcType)
}
