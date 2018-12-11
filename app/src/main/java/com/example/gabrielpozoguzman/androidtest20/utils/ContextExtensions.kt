package com.example.gabrielpozoguzman.androidtest20.utils

import android.content.Context
import android.content.Intent
import com.example.gabrielpozoguzman.androidtest20.screens.categorydetails.CategoryDetailsActivity

private const val INTENT_CATEGORY_ID = "CATEGORY_ID"

fun Context.categoryDetailIntent(categoryId: Int): Intent {
    return Intent(this, CategoryDetailsActivity::class.java).apply {
        putExtra(INTENT_CATEGORY_ID, categoryId)
    }
}

fun CategoryDetailsActivity.getIntentCategoryDetailValue(): String {
    return INTENT_CATEGORY_ID
}