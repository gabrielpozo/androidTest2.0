package com.example.gabrielpozoguzman.androidtest20.common

import android.content.Context
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.utils.categoryDetailIntent

class ScreensNavigator(val context: Context) {
    fun toCategoriesDetails(categoryId: Int) {
        context.startActivity(context.categoryDetailIntent(categoryId))
    }
}