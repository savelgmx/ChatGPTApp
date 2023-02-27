package com.example.chatgptapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "current_weather")
data class WeatherData(
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "temperature")
    val temperature: Double,
    @ColumnInfo(name = "humidity")
    val humidity: Int,
    @ColumnInfo(name = "wind_speed")
    val windSpeed: Double,
    @ColumnInfo(name = "pressure")
    val pressure: Int,
    @ColumnInfo(name = "description")
    val description: String
)
