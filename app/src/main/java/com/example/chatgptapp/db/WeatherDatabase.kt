package com.example.chatgptapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chatgptapp.model.WeatherData


@Database(entities = [WeatherData::class], version = 1)

abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}

