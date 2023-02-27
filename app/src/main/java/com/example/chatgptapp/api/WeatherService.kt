package com.example.chatgptapp.api

import com.example.chatgptapp.model.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Response<WeatherData>
}
