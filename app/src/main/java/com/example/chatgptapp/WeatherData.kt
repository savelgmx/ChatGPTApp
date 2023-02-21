package com.example.chatgptapp

data class WeatherData(
    val city: String,
    val temperature: Double,
    val humidity: Int,
    val windSpeed: Double,
    val pressure: Int,
    val description: String
)
