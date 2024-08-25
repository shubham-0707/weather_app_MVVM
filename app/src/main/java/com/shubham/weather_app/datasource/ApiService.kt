package com.shubham.weather_app.datasource

import com.shubham.weather_app.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getWeatherResponse(@Query("q") city: String, @Query("appid") apiKey: String): WeatherResponse
}