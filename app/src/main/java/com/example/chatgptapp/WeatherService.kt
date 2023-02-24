package com.example.chatgptapp

interface WeatherService {
    @GET("weather")
    fun getWeatherData(@Query("q") city: String, @Query("appid") apiKey: String): Call<WeatherData>

    companion object {
        fun create(): WeatherService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(WeatherService::class.java)
        }
    }
}
