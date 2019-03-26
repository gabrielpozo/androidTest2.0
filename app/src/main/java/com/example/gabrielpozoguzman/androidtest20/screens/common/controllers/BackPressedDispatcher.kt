package com.example.gabrielpozoguzman.androidtest20.screens.common.controllers

interface BackPressedDispatcher {
    fun registerListener(listener: BackPressedListener)
    fun unRegisterListener(listener: BackPressedListener)

}