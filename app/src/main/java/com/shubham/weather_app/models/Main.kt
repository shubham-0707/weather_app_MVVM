package com.shubham.weather_app.models

import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("temp")
    val temp: Float,

    @SerializedName("feels_like")
    val feelsLike: Float,

    @SerializedName("temp_min")
    val tempMin: Float,

    @SerializedName("temp_max")
    val tempMax: Float,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int
)