package com.example.chatgptapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.chatgptapp.model.WeatherData
import com.example.chatgptapp.db.WeatherDatabase
import com.example.chatgptapp.api.WeatherApiClient
import com.example.chatgptapp.repository.WeatherRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val application: Application
) : ViewModel() {

    suspend fun getWeatherData(city: String): LiveData<WeatherData> {
        val cachedData = repository.getWeatherData(city)
        if (cachedData != null) {
            return cachedData
        }

        val response = repository.getWeatherData(city)
    response.let {
                repository.getWeatherData(city)
                return it
            }
    }
}

