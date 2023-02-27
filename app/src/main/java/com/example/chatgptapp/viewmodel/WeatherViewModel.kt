package com.example.chatgptapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.chatgptapp.model.WeatherData
import com.example.chatgptapp.db.WeatherDatabase
import com.example.chatgptapp.api.WeatherApiClient
import com.example.chatgptapp.repository.WeatherRepository

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherRepository: WeatherRepository

    init {
        val weatherService = WeatherApiClient.create()
        val weatherDao = WeatherDatabase.getDatabase(application).weatherDao()
        weatherRepository = WeatherRepository(weatherService, weatherDao)
    }

    suspend fun getWeatherData(city: String): WeatherData? {
        val cachedData = weatherRepository.getCachedData(city)
        if (cachedData != null) {
            return cachedData
        }

        val response = weatherRepository.getWeatherData(city)
        if (response.isSuccessful) {
            val weatherData = response.body()
            weatherData?.let {
                weatherRepository.cacheData(weatherData)
                return it
            }
        }
        return null
    }
}

