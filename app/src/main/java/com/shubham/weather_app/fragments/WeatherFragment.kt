package com.shubham.weather_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.shubham.weather_app.datasource.ApiService
import com.shubham.weather_app.repository.WeatherRepository
import com.shubham.weather_app.ui.composables.WeatherComposable
import com.shubham.weather_app.viewModels.WeatherViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface WeatherListeners {
    val getWeather: (String) -> Unit
}


class WeatherFragment: Fragment(), WeatherListeners {

    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var weatherListeners: WeatherListeners

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        val apiService = Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
        val weatherRepository = WeatherRepository(apiService)
        weatherViewModel = WeatherViewModel(weatherRepository)
        weatherListeners = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = ComposeView(requireContext()).apply {
        setContent {
            val weather = weatherViewModel.weatherFlow.collectAsState()
            WeatherComposable(weather.value, weatherListeners)
        }
    }

    companion object {
        const val TAG = "WEATHER_FRAGMENT"
    }

    override val getWeather: (String) -> Unit = { city ->
        lifecycleScope.launch(Dispatchers.IO) {
            weatherViewModel.getWeather(city, "25bbf2860c3f60abee6fc1e6c9dc5374")
        }
    }
}