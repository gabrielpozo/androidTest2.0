package com.example.gabrielpozoguzman.androidtest20.utils

import android.content.Context
import android.content.Intent
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsActivity

private const val INTENT_CATEGORY_ID = "category_id"

fun Context.categoryDetailIntent(categoryId: String): Intent {
    return Intent(this, CategoryDetailsActivity::class.java).apply {
        putExtra(INTENT_CATEGORY_ID, categoryId)
    }
}