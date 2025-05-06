package com.example.findmovienew.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.findmovienew.data.db.dao.MovieDao
import com.example.findmovienew.data.db.entity.MovieEntity

@Database(version = 1, entities = [MovieEntity::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}