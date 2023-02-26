package com.example.chatgptapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherData(weatherData: WeatherData)

    @Query("SELECT * FROM WeatherData")
    fun getWeatherData(city: String): LiveData<List<WeatherData>>
}
