package com.example.gabrielpozoguzman.androidtest20.common

import android.content.Context
import com.example.gabrielpozoguzman.androidtest20.utils.categoryDetailIntent

class ScreensNavigator(val context: Context) {

    fun toCategoriesDetails(categoryId: String) {
        context.startActivity(context.categoryDetailIntent(categoryId))
    }
}