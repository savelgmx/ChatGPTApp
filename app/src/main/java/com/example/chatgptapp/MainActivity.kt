package com.example.chatgptapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.chatgptapp.model.WeatherData
import com.example.chatgptapp.ui.theme.ChatGPTAppTheme
import com.example.chatgptapp.viewmodel.WeatherViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var weatherViewModel: WeatherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewModel
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        // Call the API and update the UI
        lifecycleScope.launch {
            val weatherData = weatherViewModel.getWeatherData("Krasnoyarsk")
            // Update the UI with the weather data
            // ...
        }

        setContent {
            val weatherData = remember {
                WeatherData(
                    city = "Krasnoyarsk",
                    temperature = 0.0,
                    humidity = 0,
                    windSpeed = 0.0,
                    pressure = 0,
                    description = ""
                )
            }

            ChatGPTAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Greeting("Android")
                    WeatherScreen(weatherData)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun WeatherScreen(weatherData: WeatherData) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = weatherData.city, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Temperature: ${weatherData.temperature}°C", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Humidity: ${weatherData.humidity}%", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Wind speed: ${weatherData.windSpeed} m/s", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Pressure: ${weatherData.pressure} hPa", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Description: ${weatherData.description}", fontSize = 20.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChatGPTAppTheme {
        Greeting("Android")
    }
}
