package com.example.gabrielpozoguzman.androidtest20.categories

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(@PrimaryKey @ColumnInfo(name = "id") val id: Int, @ColumnInfo(name = "title") val title: String, @ColumnInfo(name = "href") val href: String) {
}