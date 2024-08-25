package com.shubham.weather_app.repository

import com.shubham.weather_app.datasource.ApiService
import com.shubham.weather_app.models.Weather
import com.shubham.weather_app.models.WeatherResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherRepository(private val apiService: ApiService) {

    suspend fun getWeatherResponse(city: String, apiKey: String): WeatherResponse {
        return apiService.getWeatherResponse(city, apiKey)
    }
}