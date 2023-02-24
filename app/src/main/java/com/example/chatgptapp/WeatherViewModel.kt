package com.example.chatgptapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class WeatherViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: WeatherRepository
    val weatherData: LiveData<List<WeatherData>>

    init {
        val weatherDao = WeatherDatabase.getInstance(application).weatherDao()
        repository = WeatherRepository(weatherDao)
        weatherData = repository.getWeatherData()
    }
}
