package com.example.chatgptapp.repository

import androidx.lifecycle.LiveData
import com.example.chatgptapp.db.WeatherDao
import com.example.chatgptapp.model.WeatherData
import com.example.chatgptapp.api.WeatherApiClient
import com.example.chatgptapp.api.WeatherService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WeatherRepository(private val weatherDao: WeatherDao) {
    private val weatherService: WeatherService = WeatherApiClient.create()

    fun getWeatherData(city: String): LiveData<WeatherData> {
        refreshWeatherData(city)
        return weatherDao.getWeatherData(city)
    }

    private fun refreshWeatherData(city: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val response = weatherService.getWeatherData(city, "33cc710b4ef18155198d89c3b2033f56")
            if (response.isSuccessful) {
                val weatherData = response.body()
                weatherData?.let { weatherDao.insertWeatherData(it) }
            }
        }
    }
}
