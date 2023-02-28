package com.example.chatgptapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.chatgptapp.model.WeatherData
import com.example.chatgptapp.db.WeatherDatabase
import com.example.chatgptapp.api.WeatherApiClient
import com.example.chatgptapp.repository.WeatherRepository

class WeatherViewModel(application: Application) : AndroidViewModel(application) {

    private val weatherRepository: WeatherRepository

    init {
        val weatherService = WeatherApiClient.create()
        val weatherDao = WeatherDatabase.getDatabase(application).weatherDao()
        weatherRepository = WeatherRepository(weatherDao)
    }

    suspend fun getWeatherData(city: String): LiveData<WeatherData> {
        val cachedData = weatherRepository.getWeatherData(city)
        if (cachedData != null) {
            return cachedData
        }

        val response = weatherRepository.getWeatherData(city)
    response.let {
                weatherRepository.getWeatherData(city)
                return it
            }
        }
}

