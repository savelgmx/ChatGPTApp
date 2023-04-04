package com.example.chatgptapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chatgptapp.model.WeatherData
import javax.inject.Singleton

@Singleton
@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherData(weatherData: WeatherData)

    @Query("SELECT * FROM WeatherData WHERE city = :city")
    fun getWeatherData(city: String): LiveData<WeatherData>
}
