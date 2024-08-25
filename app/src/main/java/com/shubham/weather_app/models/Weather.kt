package com.shubham.weather_app.models

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("id")
    val id: Int = -1,

    @SerializedName("main")
    val main: String = "invalid",

    @SerializedName("description")
    val description: String = "invalid",

    @SerializedName("icon")
    val icon: String = "invalid"
)