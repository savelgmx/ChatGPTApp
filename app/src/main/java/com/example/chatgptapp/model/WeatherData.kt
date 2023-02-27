package com.example.chatgptapp.model

data class WeatherData(
    val city: String,
    val temperature: Double,
    val humidity: Int,
    val windSpeed: Double,
    val pressure: Int,
    val description: String
)
