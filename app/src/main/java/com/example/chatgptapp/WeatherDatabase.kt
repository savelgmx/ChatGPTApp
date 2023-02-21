package com.example.chatgptapp

import androidx.room.RoomDatabase
import androidx.room.vo.Database

@Database(entities = [WeatherData::class], version = 1)

abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}

