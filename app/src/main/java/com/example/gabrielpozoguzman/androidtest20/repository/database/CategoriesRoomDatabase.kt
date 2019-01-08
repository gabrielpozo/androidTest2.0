package com.example.gabrielpozoguzman.androidtest20.repository.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import com.example.gabrielpozoguzman.androidtest20.categories.Category

@Database(entities = [Category::class], version = 1)
abstract class CategoriesRoomDatabase : RoomDatabase() {
    abstract fun categoriesDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: CategoriesRoomDatabase? = null

        fun getDatabase(context: Context): CategoriesRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Create database here
                Log.d("Gabriel", "Create database here")
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        CategoriesRoomDatabase::class.java,
                        "categories_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}