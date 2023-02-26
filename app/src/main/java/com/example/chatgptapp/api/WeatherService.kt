package com.example.chatgptapp.api

import com.example.chatgptapp.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): WeatherData
}
