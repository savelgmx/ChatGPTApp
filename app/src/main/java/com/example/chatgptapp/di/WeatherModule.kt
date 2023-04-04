package com.example.chatgptapp.di

import com.example.chatgptapp.db.WeatherDao
import com.example.chatgptapp.db.WeatherDatabase
import com.example.chatgptapp.repository.WeatherRepository
import com.example.chatgptapp.viewmodel.WeatherViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object WeatherModule {

    @Singleton
    @Provides
    fun provideWeatherDao(database: WeatherDatabase): WeatherDao {
        return database.weatherDao()
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(weatherDao: WeatherDao): WeatherRepository {
        return WeatherRepository(weatherDao)
    }
}
