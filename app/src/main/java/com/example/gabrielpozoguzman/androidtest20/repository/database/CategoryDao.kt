package com.example.gabrielpozoguzman.androidtest20.repository.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.gabrielpozoguzman.androidtest20.categories.Category

@Dao
interface CategoryDao {
    @Query("SELECT * from category_table ORDER BY id ASC")
    fun getAllCategories(): LiveData<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

    @Query("DELETE FROM category_table")
    fun deleteAll()
}