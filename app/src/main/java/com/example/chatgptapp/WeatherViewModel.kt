package com.example.chatgptapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.chatgptapp.api.WeatherApiClient

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

