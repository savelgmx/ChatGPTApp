package com.example.chatgptapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [WeatherData::class], version = 1)

abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}

