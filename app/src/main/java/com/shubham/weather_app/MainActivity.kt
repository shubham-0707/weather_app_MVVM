package com.shubham.weather_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import com.shubham.weather_app.fragments.WeatherFragment
import com.shubham.weather_app.ui.theme.Weather_appTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)
        startWeatherFragment()
    }

    private fun startWeatherFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, WeatherFragment(), WeatherFragment.TAG)
            .commit()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Weather_appTheme {
        Greeting("Android")
    }
}