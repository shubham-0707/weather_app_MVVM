package com.shubham.weather_app.viewModels

import androidx.lifecycle.ViewModel
import com.shubham.weather_app.models.Weather
import com.shubham.weather_app.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel(private val weatherRepository: WeatherRepository): ViewModel() {
    private val _weatherFlow = MutableStateFlow(Weather())
    val weatherFlow = _weatherFlow.asStateFlow()
    suspend fun getWeather(city: String, apiKey: String) {
        _weatherFlow.value = weatherRepository.getWeatherResponse(city, apiKey).weather.first()
    }
}