package com.example.gabrielpozoguzman.androidtest20.categories

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "category_table")
data class Category(@PrimaryKey @ColumnInfo(name = "id") val id: Int, @ColumnInfo(name = "title") val title: String, @ColumnInfo(name = "href") val href: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Category

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + href.hashCode()
        return result
    }
}