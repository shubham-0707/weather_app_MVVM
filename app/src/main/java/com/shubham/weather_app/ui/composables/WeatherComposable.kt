package com.shubham.weather_app.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.weather_app.fragments.WeatherListeners
import com.shubham.weather_app.models.Weather

@Composable
fun WeatherComposable(weather: Weather, weatherListeners: WeatherListeners) {
    val editText = remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        WeatherDetails(weather = weather)
        Spacer(Modifier.height(32.dp))
        BasicTextField(value = editText.value, onValueChange = {editText.value = it}, modifier = Modifier.background(Color.LightGray))
        Box(
            modifier = Modifier
                .width(120.dp)
                .height(48.dp)
                .background(Color.Yellow, RoundedCornerShape(100.dp))
                .clickable {
                    weatherListeners.getWeather(editText.value)
                }.align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            Text("Get Details")
        }
    }
}

@Composable
fun WeatherDetails(weather: Weather) {
    Text(text = "int is: ${weather.id}")
    Text(text = "main is: ${weather.main}")
    Text(text = "description is: ${weather.description}")
    Text(text = "icon is: ${weather.icon}")
}