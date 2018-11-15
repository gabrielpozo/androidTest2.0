package com.techyourchance.mvc.networking.questions

import com.google.gson.annotations.SerializedName

class CategoriesSchema(@field:SerializedName("id") val id: Int,
                       @field:SerializedName("title") val title: String,
                       @field:SerializedName("href") val href: String)
