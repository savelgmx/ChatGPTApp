package com.example.chatgptapp

import androidx.lifecycle.LiveData

class WeatherRepository(private val weatherDao: WeatherDao) {
    private val weatherService: WeatherService = WeatherService.create()

    fun getWeatherData(): LiveData<List<WeatherData>> {
        refreshWeatherData()
        return weatherDao.getWeatherData()
    }

    private fun refreshWeatherData() {
        val response = weatherService.getWeatherData("Krasnoyarsk", "33cc710b4ef18155198d89c3b2033f56").execute()
        if (response.isSuccessful) {
            val weatherData = response.body()
            weatherData?.let { weatherDao.insertWeatherData(it) }
        }
    }
}
