package com.example.gabrielpozoguzman.androidtest20.common

interface IMobgenPresenter<ViewMvcType> {
    fun onStart()
    fun onStop()
    fun onDestroy()
    fun bindView(listener: ViewMvcType)
}
