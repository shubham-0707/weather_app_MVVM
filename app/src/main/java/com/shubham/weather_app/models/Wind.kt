package com.shubham.weather_app.models

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    val speed: Float,

    @SerializedName("deg")
    val deg: Int
)

data class Clouds(
    @SerializedName("all")
    val all: Int
)